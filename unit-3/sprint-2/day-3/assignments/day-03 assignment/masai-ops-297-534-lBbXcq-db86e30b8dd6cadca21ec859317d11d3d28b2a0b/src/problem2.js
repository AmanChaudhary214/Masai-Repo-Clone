let subjectsData = [
    {id: 1, name: 'Javascript'},
    {id: 2, name: 'HTML'},
    {id: 3, name: 'CSS'},
    {id: 4, name: 'Java'},
    {id: 5, name: 'Rust'},
  ]
  
  // code your key-value object for subjects here
  let subObj = subjectsData.reduce((acc,index) => {
    acc[index.id] = index.name;
    return acc;
  },{});
  
  let students = [
    {id: 1, name: 'Prateek', subjectID: 5},
    {id: 2, name: 'Yogesh', subjectID: 2},
    {id: 3, name: 'Nrupul', subjectID: 4},
    {id: 4, name: 'Prateek', subjectID: 1},
  ]
  

  let newObj = students.reduce((acc, element) => {
    let name = element.name;
    let subjectID = element.subjectID;
    let subjectName = subObj[subjectID];

    acc[name] = acc[name] || [];
    acc[name].push(subjectName);

    return acc;

  }, {});

  console.log(newObj);
  
  /* 
  ----------------------------------
  create a new object called `newObj` using the `students` array &  
  the `subjectsData` array.
  
  Hint: consider creating an extra key-value object for quickly accessing subject names
  ----------------------------------
  
  Expected Output of `newObj`: 
  {
    Prateek: ["Rust", "Javascript"],
    Yogesh: ["HTML"],
    Nrupul: ["Java"],
  }
  */

 export {newObj};