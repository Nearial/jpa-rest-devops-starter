var car = {type:"Fiat", model:"500", color:"white", salesman:"Sven"};

for(prop in car){
  console.log(prop,car[prop]);
}

delete car.model;
console.log("");
for(prop in car){
  console.log(prop,car[prop]);
}

car.model = 1000;
console.log("");
for(prop in car){
  console.log(prop,car[prop]);
}

console.log("");
function Person(firstName, lastName, age){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.details = function(){return "Navn: " + this.firstName + " " + this.lastName + ", alder: " + this.age;};
};

let p = new Person("Sven", "E. Erik", 27);

console.log(p.details());


