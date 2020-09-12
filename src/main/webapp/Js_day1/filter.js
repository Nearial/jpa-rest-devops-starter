var array = ["Lars", "Jan", "Peter", "Bo", "Frederik"];
array.forEach(n => console.log(n));
var array2 = array.filter(n => n.length <= 3);
console.log("Tomt hvidt rum");
array2.forEach(n =>console.log(n));

var Map1 = array.map(n => n.toUpperCase());
console.log(Map1);

var listFunc = function(a){
    var result = ["<ul>", "</ul>"];
    var li = array.map(n => "<li>" + n + "</li>");
    
    result.splice(1, 0, li.join(""));
    
    return result.join("");
};

console.log(listFunc(array));

var cars = [
  { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
  { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
  { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
  { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
  { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
];

var newcars = cars.filter(car => car.year > 1999);
console.log(newcars);

var volvoCars = cars.filter(car => car.make === "Volvo");
console.log(volvoCars);

var cheapCars = cars.filter(car => car.price < 5000);
console.log(cheapCars);

var sqlFunc = function(a){
    var result = [];
    var line = a.map(car => "INSERT INTO cars (id,year,make,model,price) VALUES ("
    + car.id + ","
    + car.year + ","
    + "\'" +car.make + "\'" + ","
    + "\'" + car.model + "\'" + ","
    + car.price
    + ");");
    
    result.push(line.join(""));
    return result.join("");
};

console.log(sqlFunc(cars));

var msgPrinter = function(msg,delay){
  setTimeout(function(){
    console.log(msg);
  },delay);
};
console.log("aaaaaaaaaa");
msgPrinter ("bbbbbbbbbb",2000);
console.log("dddddddddd");
msgPrinter ("eeeeeeeeee",1000);
console.log("ffffffffff");
