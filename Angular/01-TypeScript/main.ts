/*
 * DataType
 */
let a : string;
let b : number;
let c : boolean;
let d : any;
let e : string[] = ['a','b'];
let f : null;
let g : undefined;
let h : void;

enum Color {
    Red = 'red',
    Green = 'green',
    Blue = 'blue'
};

let red = Color.Red;


/*
 * TypeAssertion
 */
let typeAs :string[] = []; //gán giá trị ban đầu, nếu ko sẽ là undefined
typeAs.push('new string');
console.log(typeAs);
 

/*
 * Casting
 */
let abc = [];
(<string[]>abc).length;
//or
(abc as string[]).length;


/*
 * Interface
 */

interface Point {
    x: number,
    y: number
}
let drawPoint = (point: {x:number , y:number}) => { //Inline annotation
    console.log(`Draw a point at x: ${point.x} and y: ${point.y}`); 
}

//tránh dài dòng như line 43 -> sử dụng interface 
let movePoint = (point: Point) => {};

let getDistance = (pointA: Point, pointB: Point) => {};
drawPoint ({
    x: 1,
    y: 2
});

/*
 * Cohesion
 */
//class
class Dot {
    x: number;
    y: number;

    constructor(x: number, y: number) {
        this.x = x;
        this.y = y;
    }

    drawDot() {
        console.log(`Draw a point at x: ${this.x} and y: ${this.y}`); 
    }
}

let dot = new Dot(1, 2);
dot.drawDot();

/*
 * Access Modifier 
 */
class Cat {
    private name: string; //ngăn ko cho sử dụng bên ngoài class
    private age: number;

    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }

    catInfo() {
        console.log(`Cat=[name: ${this.name}, age: ${this.age}]`);
    }
}

let cat = new Cat('Dai', 10);
cat.catInfo();
// cat.name = 'Giang';  // ko thể khai báo vì name là biến private

//version ngắn gọn hơn

class Dog {
    constructor(private name: string, private age: number){}

    dogInfo() {
        console.log(`Dog=[name: ${this.name}, age: ${this.age}]`);
    }
}
let dog = new Dog('Giang', 2);
dog.dogInfo();


/*
 * Getters n Setters 
 */
class Hooman {
    constructor(private _name: string, private _age: number) {};
    
    hoomanInfo() {
        console.log(`Hooman=[name: ${this._name}, age: ${this._age}]`);
    }

    get name() {    //đây là property, không phải method
        return this._name;
    }

    set name(value: string) {   //đây là property, không phải method
        if(value.length < 2) {
            throw new Error('Value cannot shorter than 2');
        }

        this._name = value;
    }
}

let hooman = new Hooman('Kim', 27);
hooman.name = 'Duong';
console.log(`Hooman name is ${hooman.name}`); 
