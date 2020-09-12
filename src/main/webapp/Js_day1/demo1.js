console.log("Hello World, i Know how to count");

let a = ['a','b','c'];

a.forEach(n => console.log(n));

let b = a.map(n => n.toUpperCase());
console.log(b);

[1,2,3,4].forEach(n=>console.log(n));
[1,2,3,4].forEach(udskriv);
[1,2,3,4].forEach(udskrivdeluxe);
[1,2,3,4].forEach(console.log);

function udskriv(n){
    console.log(n);
}

function udskrivdeluxe(n){
    console.log('tal: ' + n);
}

udskriv(215);

function add (a, b){
    return a+b;
}

console.log(add(2,3));

