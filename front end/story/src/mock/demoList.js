import Mock from "mockjs";

Mock.mock("/parameter/demoList", {
  'comments|3-5':[{
    title: "@title(3)",
    author: "@name(3)",
    article: "@cparagraph)",
    star: 11
  }]
});
// 'PageInfo':[{
//
// }]
