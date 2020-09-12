//Observe: no return type, no type on parameters
function add(n1, n2){
    return n1 + n2;
}

var sub = function(n1,n2){
    return n1 - n2;
};

var cb = function(n1,n2, callback){
    try{   
    if (typeof n1 !== "number") throw "n1 er ikke et tal!";
    if (typeof n2 !== "number") throw "n2 er ikke et tal!";
    if (typeof callback !== "function") throw "callback er ikke en function";
        } catch(e){
            console.error("fejl: " + e);
        return;   
        }
    return "Result from the two numbers: " + n1 + " + " + n2 + " = " + callback(n1,n2);
};

var mul = function(n1,n2){
    return n1 * n2;  
};

var div = function(n1,n2){
    try{
        if(n1 === 0) throw "n1 er nul";
        if(n2 === 0) throw "n2 er nul";
    }catch(e){
        console.error("Fejl: du må ikke dividere med nul");
        return;
    }
    return n1 / n2;  
};

console.log(add(1,2));
console.log(add);
console.log(add(1,2,3));
console.log(add(1));
console.log(cb(3,3,add));
console.log(cb(4,3,sub));
console.log(cb(3,3,add()));
console.log(cb(3,"hh",add));
console.log(cb(3,3,mul));
console.log(cb(15,3,div));