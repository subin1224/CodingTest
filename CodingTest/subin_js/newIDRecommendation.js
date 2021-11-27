// https://programmers.co.kr/learn/courses/30/lessons/72410?language=javascript
// 신규 아이디 추천
/*
아이디의 길이는 3자 이상 15자 이하여야 합니다.
아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
*/

// 1) repeat
/*
https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/String/repeat
String.prototype.repeat()
: 문자열을 주어진 횟수만큼 반복해 붙인 새로운 문자열을 반환
str.repeat(count);
매개변수
 - count: 문자열을 반복할 횟수. 양의 정수여야 함.
           반복 횟수는 무한대보다 작아야 하며 최대 문자열 크기를 넘어선 ㅇ나됨
*/
function solution(new_id) {
    const answer = new_id
            .toLowerCase() // 1
            .replace(/[^\w-_.]/g, '') // 2
            .replace(/\.+/g, '.') // 3
            .replace(/^\.|\.$/g, '') // 4
            .replace(/^$/, 'a') // 5
            .slice(0, 15).replace(/\.$/, ''); // 6
        const len = answer.length;
        return len > 2 ? answer : answer + answer.charAt(len - 1).repeat(3 - len);
}


// 2) padEnd
//https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/String/padEnd
//padEnd() 메서드는 현재 문자열에 다른 문자열을 채워, 주어진 길이를 만족하는 새로운 문자열을 반환합니다.
//채워넣기는 대상 문자열의 끝(우측)부터 적용됩니다.
//str.padEnd(targetLength [, padString])
//targetLength : 목표 문자열 길이. 현재 문자열의 길이보다 작다면 채워넣지 않고 그대로 반환
//padString Optional// : 현재 문자열에 채워넣을 다른 문자열. 문자열이 너무 길어
//    목표 문자열 길이를 초과한다면 좌측 일부를 잘라서 넣음
//    기본값은 ""
//반환값 : 끝부터 주어진 문자열로 채워 목표 길이를 만족하는 String
const solution = (new_id) => {
    const id = new_id
        .toLowerCase()
        .replace(/[^\w\d-_.]/g, '')
        .replace(/\.{2,}/g, '.')
        .replace(/^\.|\.$/g,
        '')
        .padEnd(1, 'a')
        .slice(0, 15)
        .replace(/^\.|\.$/g, '')
    return id.padEnd(3, id[id.length-1])
}


