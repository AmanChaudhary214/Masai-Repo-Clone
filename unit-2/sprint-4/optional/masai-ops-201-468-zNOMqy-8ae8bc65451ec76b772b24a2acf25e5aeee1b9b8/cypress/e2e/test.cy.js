import data from "../../submissionData.json"; // do not create this file
// let data = [{ submission_link: "http://localhost:8080/", id: 67890 }];
import "cypress-localstorage-commands";

// import { start, submitData } from "../../../data";
describe("Test", function () {
  let acc_score = 1;
  data.map(({ submission_link: url, id }) => {
    let apirequestData = [];
    if (url.charAt(url.length - 1) != "/") {
      url = url + "/";
    }
    if (url && url.length) {
      beforeEach(() => {
        cy.restoreLocalStorage();
      });
      afterEach(() => {
        cy.saveLocalStorage();
      });

      it(`Search with less than 3 words shows alert`, () => {
        cy.visit(url);
        cy.get("#search-inp").type("av");
        cy.get("#search-btn").click();
        cy.on("window:alert", (str) => {
          acc_score += 0.5;
          expect(str).to.eq("Movie Name should be greater than 3 words");
          acc_score += 0.5;
        });
      }); // 1

      it(`Seach with avengers`, () => {
        cy.intercept(`https://www.omdbapi.com/*`).as("apiRequest");
        cy.get("#search-inp").clear().type("avengers");
        cy.get("#search-btn").click();
        cy.wait("@apiRequest").then((data) => {
          apirequestData = data.response.body.Search;
           expect(data.response.statusCode).to.eq(200);
          acc_score += 2;
        });
      }); // 2

      it(`Check if the student was able to loop through the data and show on DOM`, () => {
        expect(apirequestData.length).not.to.eq(0);
        cy.get("#movie_container>div")
          .should("have.length", apirequestData.length)
          .then(() => {
            acc_score += 1;
          });
      }); // 1
    }

    it(`generate score`, () => {
      //////////////
      console.log(acc_score);
      let result = {
        id,
        marks: Math.floor(acc_score),
      };
      result = JSON.stringify(result);
      cy.writeFile("results.json", `\n${result},`, { flag: "a+" }, (err) => {
        if (err) {
          console.error(err);
        }
      });
      //////////////////
    });
  });
});
