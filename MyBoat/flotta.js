
function httpGet(theUrl)
{
    console.log(theUrl);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, true ); // false for synchronous request
    xmlHttp.setRequestHeader('Access-Control-Allow-Headers', '*');
    xmlHttp.setRequestHeader('Content-type', 'application/json');
    xmlHttp.setRequestHeader('Access-Control-Allow-Origin', '*');
    xmlHttp.responseType = 'json'
    xmlHttp.send(null);
    console.log(xmlHttp.statusText);
    console.log(xmlHttp.response);
    console.log(xmlHttp.responseType);
    
    return xmlHttp;
}

