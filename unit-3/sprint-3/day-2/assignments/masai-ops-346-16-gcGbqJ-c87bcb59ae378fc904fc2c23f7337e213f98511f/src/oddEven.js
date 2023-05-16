function getData(data) {
    return new Promise((resolve,reject)=>{
        if(typeof(data)=='number'){
            if(data%2==0){
                setTimeout(()=>{
                    resolve('even')
                },4000)
            }
            if(data%2!=0){
                setTimeout(()=>{
                    resolve('odd')
                },2000)
            }
        }   
        else{
            reject('error')
        }
    })
}

export default getData
