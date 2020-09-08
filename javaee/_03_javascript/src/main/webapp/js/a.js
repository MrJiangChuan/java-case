// alert(789)
// for (var i = 0; i < 100; i++) {
//     document.write(i+'<br/>')
// }
//1.数据类型
var a = true;
var b = 'ccc';
var c = 231;
var d = 3.23;
var e = null;
var f;

document.write(typeof a + '<br/>')
document.write(typeof b + '<br/>')
document.write(typeof c + '<br/>')
document.write(typeof d + '<br/>')
document.write(typeof e + '<br/>')
document.write(typeof f + '<br/>')

//2.运算符
var x = 12%5;
document.write(x+'<br/>');
var y = x>3?1:4;
document.write(y+'<br/>');
document.write((1>2 || 2>1) +'<br/>');

//3.流程控制
if(x>1){
    document.write(12+'<br/>')
}else {
    document.write(22+'<br/>')
}
for (var i = 0; i < 6; i++) {
    document.write(i)
}
//5.方法
function f1() {
    return 'f1'
}
document.write(f1()+'<br/>');
function f2() {
    document.write('f2'+'<br/>')
}
f2();
var c = function (a, b) {
    return a*b;
};
document.write(c(12,12)+'<br/>');
// let d = x => 2*x;
// document.write(d(12,12)+'<br/>')
//6.数组
var s = Array(12,33,44,55);
for (var i = 0; i < s.length; i++) {
    document.write(s[i]+'<br/>');
}
document.write(s[2]);
//7.内置对象
document.write(new Date().toDateString()+'<br/>');
document.write(Math.ceil(1.2)+'<br/>');
document.write(Math.floor(1.2)+'<br/>')
