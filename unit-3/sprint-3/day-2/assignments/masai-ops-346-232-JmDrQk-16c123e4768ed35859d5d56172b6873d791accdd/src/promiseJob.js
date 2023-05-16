function job(delay, value) {
    
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            resolve(value);
        }, delay)
    })
}

var results;

export { job, results };
