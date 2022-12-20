const urlLoc = "http://127.0.0.1:8080/produtos/busca";

document.getElementById('btn-busca').onclick = function() {
  let q = document.getElementById('codBusc');
  let novaUrl = urlLoc + "/" + q.value;
  window.open(novaUrl);
  console.log(novaUrl);
};