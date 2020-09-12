//A
var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "hanne", "Sanne"];

//B
var all = boys.concat(girls);
console.log(all);

//C
console.log(all.join());
console.log(all.join('-'));

//D
all.unshift("hans", "kurt");
//E
all.push("Lone", "Gitte");
console.log(all);

//F
all.shift();
//G
all.pop();
console.log(all);

//H
all.splice(3, 2);
console.log(all);


//I
all.reverse();
console.log(all);

//J
all.sort();
console.log(all);

//K
all.sort(function (a, b) {
    return a.toLowerCase().localeCompare(b.toLowerCase());
});

//L
var allMap = all.map(n => n.toUpperCase());
console.log(allMap);

//M
var allFilter = allMap.filter(name => name.charAt(0) === "l" || name.charAt(0) === ("L"));
console.log(allFilter);