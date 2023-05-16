// function studentData(firstName, lastName, age, mark, h1,h2,h3) {
//     let fullName = firstName+" "+lastName;
//     let hobbies = [h1, h2, h3];
//     let getInfo = () => {
//       return (fullName+"'s age is "+age+".");
//     };
//     let marks = mark;
//     getResult = (marks) => {
//       let total = 0;
//       let n= marks.length;
//       for (let i=0; i<n; i++)
//       {
//         total = total+marks[i];
//       }
//       if (total/n>=50) {
//         return "PASS";
//       }
//       else {
//         return "FAIL";
//       }
//     }
//     return {
//       fullName,
//       age,
//       hobbies,
//       getInfo,
//       getResult,
//     };
//   }

// let data = studentData(
//   "Vivek",
//   "Agarwal",
//   38,
//   [50, 60, 70],
//   "Singing",
//   "Coding",
//   "Meditating"
// );

// export {studentData}







function studentData(firstName, lastName, age, marks, ...hobbies) {
  return {
    fullName : `${firstName} ${lastName}`,
    age : age,
    hobbies : hobbies,
    getInfo : () => {
      return (this.fullName+"'s age is "+this.age+".");
    },
    getResult : () => {
      let total = 0;
      let n= marks.length;
      for (let i=0; i<n; i++)
      {
        total = total + marks[i];
      }
      let result = (total/n) >= 50 ? "Result: PASS" : "Result: FAIL";
      return result;
    }
  }
}

studentData("Vivek", "Agarwal", 38, [50, 60, 70], "Singing", "Coding", "Meditating");

export {studentData}