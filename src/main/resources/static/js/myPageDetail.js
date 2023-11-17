const express = require('express');
const request = require('request');
const app = express();
const port = 3000;

// CORS 허용 설정 (이 부분을 필요에 따라 조정)
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*'); // 모든 도메인에서 접근을 허용합니다.
  res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
  next();
});

// 이미지 요청을 이미지 서버로 전달
app.get('/proxy', (req, res) => {
  const imageUrl = req.query.imageUrl; // 이미지 URL은 쿼리 파라미터로 전달됩니다.
  request(imageUrl).pipe(res); // 이미지 서버로부터 이미지를 가져와 클라이언트에게 전달합니다.
});

app.listen(port, () => {
  console.log(`Proxy server is running on port ${port}`);
});


function saveAs(uri, fileName) {
  const link = document.createElement("a");
  link.href = uri;
  link.download = fileName;

  document.body.appendChild(link);

  link.click();

  document.body.removeChild(link);
}


html2canvas(document.querySelector("#capture")).then(canvas => {
    saveAs(canvas.toDataURL(), 'fileName.png');
});