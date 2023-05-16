# Web-Fetch-Movie-App-Omdb

## Submission Instructions [Please note]

## Maximum Marks - 5

- The Submission should not contain spaces, for example /js-101 folder/eval will not work
- Do not push node_modules and package_lock.json to github

```
 ✅ able to submit the app - 1 mark ( minimum score )
 ✅ Search with less than 3 words shows alert - 1 marks
 ✅ Seach with avengers - 2 marks
 ✅ Check if the student was able to loop through the data and show on DOM - 1 marks
```

## Folder structure

- index.html
- Please make sure you don't make any changes to files except for the files mentioned above.

## Description

- Go to omdbapi.com , create account and explore API documentation.

- There you will get an apikey. Use that for your api request
- Now in your index.js we have an input tag with an id:- `search-inp` and a button with an id:- `search-btn`.
- When clicked on the button if the input's value has < 3 words show an alert with text `Movie Name should be greater than 3 words`.
- Else make fetch request to this api:- `https://www.omdbapi.com/?apiKey=<apiKey>&s=<searchQuery>`.
- Now loop over the data and make small cards and append them inside the div with id:- `movie_container`.
- Reffer to this image for UI:- ![image](https://i.imgur.com/0gKem3t.jpeg)

**Note:- Do not use any other names for the methods other than mentioned.**

#### General guidelines

- The system on cp.masaischool.com may take between 1-20 minutes for responding,
- so we request you to read the problem carefully and debug before itself
- we also request you not to just submit it last minute
- try to keep one submission at a time
