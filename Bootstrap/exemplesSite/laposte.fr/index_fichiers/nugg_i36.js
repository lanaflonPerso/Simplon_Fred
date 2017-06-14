/*
var now = (new Date()).getTime();
if(typeof Storage !== "undefined" && typeof localStorage !== "undefined")
{
  var mdlLastTime = localStorage.getItem("mdlLastTime");
  if (typeof mdlLastTime === "undefined" || now - mdlLastTime > 24*60*60)
  {
    doMDL = true;
    localStorage.setItem("mdlLastTime",now);
  }
  else
    doMDL = false;
}  
else
  doMDL = now % 20 == 0;  // 5% of time

if (doMDL)
{
  MDLSEGDAP = function (json) {
    var product = "";
    var jsonStr = JSON.stringify(json);
    console.log(jsonStr);
    var r = /"755"/gi;
    var n = r.exec(jsonStr);
    if (n)
      product += ",mdl_ride";
    var r = /"5(71|83)"/gi;
    var n = r.exec(jsonStr);
    if (n)
      product += ",mdl_marketplace";
    var r = /"7(01|17|03|07|05|13|23)"/gi;
    var n = r.exec(jsonStr);
    if (n)
      product += ",mdl_camaieu";
		var r = /"6(01|03|05)"/gi;
    var n = r.exec(jsonStr);
    if (n)
      product += ",mdl_bouygues";
    if (product)
      new Image().src="//adnext.fr/track.adv?ap=102848&expi=3&ts="+(new Date).getTime()+"&product="+product.substr(1,1000);
  };
  try {
    top.MDLSEGDAP = parent.MDLSEGDAP = MDLSEGDAP;
  } catch(e) {};
  
  s = document.createElement("script");
  s.src = "//ws.mediapostcommunication.net/api/adverline_sj?mdel=ADNEXT_ONLINE&_cid=adnext_planetride_marketplace_camaieu_bouygues&callback=MDLSEGDAP";
  document.body.appendChild(s);
}
*/

setTimeout(
	function () {
		var product = "";
		var r = /(^|,)d2_[34]($|,)/gi;
		if (r.exec(ngg_content))
			product += ",ngg_lidl";
		r = /(^|,)i10_[1234]($|,)/gi;
		if (r.exec(ngg_content))
			product += ",ngg_marketplace";
		r = /(^|,)h9_1|i(27|8)_[1234]($|,)/gi;
		if (r.exec(ngg_content))
			product += ",ngg_evasec";
		r = /(^|,)h7_1|i(12|16)_[123]($|,)/gi;
		if (r.exec(ngg_content))
			product += ",ngg_bouygues";	
    r = /(^|,)d2_[3456]($|,)/gi;
		if (r.exec(ngg_content))
			product += ",ngg_camif";
    r = /(^|,)i2_[123]|h1_1($|,)/gi;
		if (r.exec(ngg_content))
			product += ",ngg_peugeot";
        
    r1 = /(^|,)d2_[345]($|,)/gi;
    r2 = /(^|,)d10_2($|,)/gi;
    r3 = /(^|,)h9_1|i(27|8)_[1234]($|,)/gi;
		if (r1.exec(ngg_content) && r2.exec(ngg_content) && r3.exec(ngg_content))
			product += ",ngg_accor";
    
		if (product) 
			new Image().src="//adnext.fr/track.adv?ap=102848&expi=3&ts="+(new Date).getTime()+"&product="+product.substr(1,1000);
},2000)	;

/*
try {
	s = document.createElement("script");
	s.src = "https://data.api.xiko.fr/tag.js";
	s.async = true;
	document.body.appendChild(s);
} catch(e){}

*/