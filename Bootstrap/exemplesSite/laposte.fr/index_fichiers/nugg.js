if ( typeof(nugg_loaded) == "undefined")
{
	if ( typeof(nuggsid) == "undefined")
		nuggsid = 846370158;
	function L(u){e=document.createElement("script");e.language="JavaScript";e.type="text/javascript";e.src=u;p=((document.body)?document.getElementsByTagName("head")[0]:document.body);p.insertBefore(e,p.firstChild);}
	var ngg_content ="";
	nuggrid = false;
	try { nuggrid = encodeURIComponent(parent.context.location.href); } catch(e) {};
	try { nuggrid = encodeURIComponent(top.location.href); } catch(e) {};
	if (nuggrid)
	{
    if ( window.location.protocol != 'https:' )
      L("http://adverline.nuggad.net/rc?nuggn=1427996861&nuggsid="+nuggsid+"&nuggrid="+nuggrid);
    else
      L("https://adverline-s.nuggad.net/rc?nuggn=1427996861&nuggsid="+nuggsid+"&nuggrid="+nuggrid);
	}
	
	//(new Image).src = "//ads.stickyadstv.com/data-registering?dataProviderId="+nuggsid+"&"+(ngg_content.replace(/,/g,"&").replace(/_/g,"="));
	(new Image).src="https://eb2.3lift.com/getuid?redir=//adnext.fr/foreignkey.adv?3lift_id=%24UID";
}
var nugg_loaded = true;
L("//ads.adverline.com/tools/nugg_i36.js");
