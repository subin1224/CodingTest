// https://school.programmers.co.kr/learn/courses/30/lessons/150370

const solution = (today, terms, privacies) => {
  const termsMap = new Map();
  terms.forEach((term) => {
    const termArray = term.split(" ");
    termsMap.set(termArray[0], termArray[1]);
  });
  const expirationPrivacies = privacies.map((item) => {
    const privacyArray = item.split(" ");
    const term = termsMap.get(privacyArray[1]);
    const date = new Date(privacyArray[0]);
    return new Date(date.setMonth(date.getMonth() + +term));
  });

  const answer = expirationPrivacies.reduce((arr, item, index) => {
    const todayDate = new Date(today);
    if (todayDate >= item) {
      arr.push(index + 1);
    }
    return arr;
  }, []);

  return answer;
};
