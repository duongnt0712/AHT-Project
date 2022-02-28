/*
 * DataType
 */
var a;
var b;
var c;
var d;
var e = ['a', 'b'];
var f;
var g;
var h;
var Color;
(function (Color) {
    Color["Red"] = "red";
    Color["Green"] = "green";
    Color["Blue"] = "blue";
})(Color || (Color = {}));
;
var red = Color.Red;
/*
 * TypeAssertion
 */
var typeAs = []; //gán giá trị ban đầu, nếu ko sẽ là undefined
typeAs.push('new string');
console.log(typeAs);
/*
 * Casting
 */
var abc = [];
abc.length;
//or
abc.length;
var drawPoint = function (point) {
    console.log("Draw a point at x: ".concat(point.x, " and y: ").concat(point.y));
};
//tránh dài dòng như line 43 -> sử dụng interface 
var movePoint = function (point) { };
var getDistance = function (pointA, pointB) { };
drawPoint({
    x: 1,
    y: 2
});
/*
 * Cohesion
 */
//class
var Dot = /** @class */ (function () {
    function Dot(x, y) {
        this.x = x;
        this.y = y;
    }
    Dot.prototype.drawDot = function () {
        console.log("Draw a point at x: ".concat(this.x, " and y: ").concat(this.y));
    };
    return Dot;
}());
var dot = new Dot(1, 2);
dot.drawDot();
/*
 * Access Modifier
 */
var Cat = /** @class */ (function () {
    function Cat(name, age) {
        this.name = name;
        this.age = age;
    }
    Cat.prototype.catInfo = function () {
        console.log("Cat=[name: ".concat(this.name, ", age: ").concat(this.age, "]"));
    };
    return Cat;
}());
var cat = new Cat('Dai', 10);
cat.catInfo();
// cat.name = 'Giang';  // ko thể khai báo vì name là biến private
//version ngắn gọn hơn
var Dog = /** @class */ (function () {
    function Dog(name, age) {
        this.name = name;
        this.age = age;
    }
    Dog.prototype.dogInfo = function () {
        console.log("Dog=[name: ".concat(this.name, ", age: ").concat(this.age, "]"));
    };
    return Dog;
}());
var dog = new Dog('Giang', 2);
dog.dogInfo();
/*
 * Getters n Setters
 */
var Hooman = /** @class */ (function () {
    function Hooman(_name, _age) {
        this._name = _name;
        this._age = _age;
    }
    ;
    Hooman.prototype.hoomanInfo = function () {
        console.log("Hooman=[name: ".concat(this._name, ", age: ").concat(this._age, "]"));
    };
    Object.defineProperty(Hooman.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (value) {
            if (value.length < 2) {
                throw new Error('Value cannot shorter than 2');
            }
            this._name = value;
        },
        enumerable: false,
        configurable: true
    });
    return Hooman;
}());
var hooman = new Hooman('Kim', 27);
hooman.name = 'Duong';
console.log("Hooman name is ".concat(hooman.name));
