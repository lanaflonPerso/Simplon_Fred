
var MetrixLab_URLwebsite = encodeURIComponent(window.location.href);

var MetrixLab_OverlayImageName;

var MetrixLab_is_Btq_Url;

if(MetrixLab_URLwebsite.indexOf("boutique.laposte.fr") > -1)
{
	document.cookie = "boutique_metrixlab=checked;domain=laposte.fr";
}
else if(MetrixLab_URLwebsite.indexOf("laposte.fr") > -1)
{
	document.cookie = "only_laposte_metrixlab=checked;domain=laposte.fr";
}

////console.log('MetrixLab_URLwebsite'+MetrixLab_URLwebsite);

if (MetrixLab_URLwebsite != null)
{	
	//MetrixLab_is_Btq_Url = (MetrixLab_URLwebsite.indexOf("boutiqueducourrier") > -1) ? 1 : 0;
	MetrixLab_is_Btq_Url = (MetrixLab_URLwebsite.indexOf("boutique.laposte.fr") > -1 || MetrixLab_URLwebsite.indexOf("laposte.fr/particulier") > -1 || MetrixLab_URLwebsite.indexOf("courrier.extra.laposte.fr") > -1) ? 1 : 0;
	////console.log('MetrixLab_is_Btq_Url_12'+MetrixLab_is_Btq_Url);
}

MetrixLab_OverlayTypeName = MetrixLab_CRM_OverlayType();	
function MetrixLab_CRM_OverlayType() 
{
	var MetrixLab_exit=100;     //Enter percent
	var MetrixLab_entry=0;    //Enter percent
	var MetrixLab_nosurvey=0; //Enter percent

	//***Random Number Generated 
	var MetrixLab_rndNumber=Math.random()*100;
////console.log('main'+MetrixLab_rndNumber);
	//***Exit Survey Interception Rate
	if (MetrixLab_rndNumber>(100-MetrixLab_exit))
	{
		////console.log('exit'+MetrixLab_rndNumber);
		MetrixLab_OverlayTypeName = 0;
		////console.log("exit");
		return MetrixLab_OverlayTypeName;
	}
	//***Entry Survey Interception Rate
	if (MetrixLab_rndNumber<=MetrixLab_entry)
	{	////console.log('entry'+MetrixLab_rndNumber);					
		MetrixLab_OverlayTypeName = 1;
		////console.log("entry");
		return MetrixLab_OverlayTypeName;
	}
	//***NO Survey Interception Rate
	if (MetrixLab_rndNumber>MetrixLab_entry && MetrixLab_rndNumber<=(100-MetrixLab_exit))
	{////console.log('nosurvey'+MetrixLab_rndNumber);	
		MetrixLab_OverlayTypeName = 2;
		////console.log("no survey");
		return MetrixLab_OverlayTypeName;
	}
}	


function MetrixLab_SetAnotherCookie()
{
	var MetrixLab_expires2 = new Date();
	MetrixLab_expires2.setTime(MetrixLab_expires2.getTime() + (180*24*60*60*1000));
			
	document.cookie = "MetrixLab_p21408_isBoutiqurl=" + MetrixLab_is_Btq_Url + "; expires=" + MetrixLab_expires2.toGMTString() + "; path=/;";
}

function MetrixLab_SetGlobOfWebsite()
{
	var MetrixLabGLOB_Time_extra = new Date();
	var MetrixLabGLOB_Script_extra = document.createElement('script');
	MetrixLabGLOB_Script_extra.src=MetrixLab_Protocol+'//invitation.opinionbar.com/popups/'+MetrixLab_PopupFolderName+'/cookie.asp?s='+MetrixLab_CookieName+'_GLOB_extra&m=extraset&t='+MetrixLabGLOB_Time_extra.getTime()+'&extras='+MetrixLab_is_Btq_Url;
	MetrixLabGLOB_Script_extra.type='text/javascript';
	var MetrixLabGLOB_Body_extra = document.getElementsByTagName('body').item(0);
	MetrixLabGLOB_Body_extra.appendChild(MetrixLabGLOB_Script_extra); 
}



var MetrixLab_Intercept = 0;//5;//0;
MetrixLab_OverlayImageName = "overlay_p21408.png";
var MetrixLab_OverlayType = 'exit';

var MetrixLab_PopupFolderName = 'p21408';
var MetrixLab_ProjectNumber;
var MetrixLab_CookieFolderName = 'p21408';

//if true the MetrixLab_CookieFolderName name should be the same in all projects
var MetrixLab_GLOB_CookieSetup = true;

var MetrixLab_PrivacyLanguage = 'fr';

var MetrixLab_DivStartLeft = '100';
var MetrixLab_DivStartTop = '100';

var MetrixLab_OverlayWidth = 450;
var MetrixLab_OverlayHeight = 350;

var MetrixLab_Coordinate_YesButton = '50,267,200,303';
var MetrixLab_Coordinate_NoButton = '250,267,400,303';
var MetrixLab_Coordinate_CloseButton = '0,0,0,0';
var MetrixLab_Coordinate_PrivacyButton = '0,0,0,0';
var MetrixLab_Coordinate_MetrixButton = '0,0,0,0';



switch(MetrixLab_OverlayTypeName)
{
case 0:
//////////////////////////////////////////////////////////////////
if(MetrixLab_is_Btq_Url == 0)
{
	console.log('MetrixLab_is_Btq_Url_101'+MetrixLab_is_Btq_Url);
	MetrixLab_Intercept = 5;//0;// 5;//1;
	MetrixLab_OverlayImageName = "overlay_p13859.png";

	MetrixLab_ProjectNumber = 'p13859_fr';
	
	MetrixLab_OverlayWidth = 350;
	MetrixLab_OverlayHeight = 300;
	
	MetrixLab_Coordinate_YesButton = '30,231,152,259';
	MetrixLab_Coordinate_NoButton = '198,231,320,259';
	
}
else
{
	console.log('MetrixLab_is_Btq_Url_116'+MetrixLab_is_Btq_Url);
	MetrixLab_Intercept = 5;//0;//5;//1
	MetrixLab_OverlayImageName = "overlay_p21408.png";

	MetrixLab_ProjectNumber = 'p21408';
	
	MetrixLab_OverlayWidth = 450;
	MetrixLab_OverlayHeight = 350;
	
	MetrixLab_Coordinate_YesButton = '50,267,200,303';
	MetrixLab_Coordinate_NoButton = '250,267,400,303';

}
//////////////////////////////////////////////////////////////////
break;
}



var MetrixLab_AutoCloseInterval=0;
var MetrixLab_ForceData='';
var MetrixLab_ReadCookieName = "xtvid";
/*if(document.cookie.indexOf("xtvid")>-1){
var MetrixLab_ForceUtmz = '999,1,' + MetrixLab_GetCookieValue(MetrixLab_ReadCookieName);

MetrixLab_ForceData = '999,1,' + MetrixLab_GetCookieValue(MetrixLab_ReadCookieName);	
}*/


//console.log('MetrixLab_ForceData'+ MetrixLab_ForceData);
var MetrixLab_CookieName = "MetrixLab"+MetrixLab_CookieFolderName;
var MetrixLab_UserID='';

var MetrixLabGLOB_cookie;
var MetrixLabGLOB_Try_count = 20;
var MetrixLab_Protocol = document.location.protocol;


function MetrixLab_GetCookieValue(CookieName)
{
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++)
	{
		x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		x=x.replace(/^\s+|\s+$/g,"");
		if (x==CookieName)
		{
			return unescape(y);
		}
	}
}


function MetrixLab_SetUserID()
{
	var Today = new Date();
	MetrixLab_UserID=''+Today.getFullYear()+'_'+(Today.getMonth()+1)+'_'+Today.getDate()+'_'+Today.getHours()+'_'+Today.getMinutes()+'_'+Today.getSeconds()+'_'+Today.getMilliseconds();	
}

function MetrixLab_isCookieEnabled()
{
    var cookieEnabled=(navigator.cookieEnabled)? true : false;
    
    if (typeof navigator.cookieEnabled=="undefined" && !cookieEnabled)
    { 
	    document.cookie="MetrixLabTestCookie";
	    cookieEnabled=(document.cookie.indexOf("MetrixLabTestCookie")!=-1)? true : false;
    }    
    return cookieEnabled;      	
}

function MetrixLab_GetRandomNumber(MetrixLab_minValue,MetrixLab_maxValue)
{
    var MetrixLab_result = 0;

    if (MetrixLab_minValue<=MetrixLab_maxValue)
    {
	    MetrixLab_result=Math.round((Math.random()*(MetrixLab_maxValue-MetrixLab_minValue+1))+MetrixLab_minValue-0.5);
	}	
	return MetrixLab_result;
}

function MetrixLab_SetCookie()
{
    var MetrixLab_expires = new Date();
	MetrixLab_expires.setTime(MetrixLab_expires.getTime() + (180*24*60*60*1000));
	document.cookie = MetrixLab_CookieName+"=1; expires=" + MetrixLab_expires.toGMTString() + "; path=/;";

	if (MetrixLab_GLOB_CookieSetup)
	{	
		MetrixLab_GLOB_setCookie();
	}
}


function MetrixLab_ShowOverlay()
{
	MetrixLab_SetUserID();
    MetrixLab_LoadOverlay();
    if (MetrixLab_AutoCloseInterval>0)
    {
            setTimeout("MetrixLab_CloseBanner();",MetrixLab_AutoCloseInterval*1000);
    }
}


function MetrixLab_GLOB_setCookie()
{
	var MetrixLabGLOB_Time = new Date();
	var MetrixLabGLOB_Script = document.createElement('script');
	MetrixLabGLOB_Script.src=MetrixLab_Protocol+'//invitation.opinionbar.com/popups/'+MetrixLab_PopupFolderName+'/cookie.asp?s='+MetrixLab_CookieName+'_GLOB&m=set&t='+MetrixLabGLOB_Time.getTime();
	MetrixLabGLOB_Script.type='text/javascript';
	var MetrixLabGLOB_Body = document.getElementsByTagName('body').item(0);
	MetrixLabGLOB_Body.appendChild(MetrixLabGLOB_Script); 
}



function MetrixLab_GLOB_getCookie()
{
	var MetrixLabGLOB_Time = new Date();
	var MetrixLabGLOB_Script = document.createElement('script');
	MetrixLabGLOB_Script.src=MetrixLab_Protocol+'//invitation.opinionbar.com/popups/'+MetrixLab_PopupFolderName+'/cookie.asp?s='+MetrixLab_CookieName+'_GLOB&m=get&t='+MetrixLabGLOB_Time.getTime();
	MetrixLabGLOB_Script.type='text/javascript';
	var MetrixLabGLOB_Body = document.getElementsByTagName('body').item(0);
	MetrixLabGLOB_Body.appendChild(MetrixLabGLOB_Script); 
}

function MetrixLab_CheckXTVID(){ //Check for xtvid cookie
	if (document.cookie.indexOf(MetrixLab_ReadCookieName)>-1){
		MetrixLab_ForceData = MetrixLab_ForceData+'999,1,' + MetrixLab_GetCookieValue(MetrixLab_ReadCookieName) + ';';
		MetrixLab_CheckCookie();
	}
	else{
		MetrixLab_CheckXTVID();//Call until xtvid cookie is there
	}
} 

function MetrixLabGLOB_checkCookie()
{                
    if (typeof MetrixLabGLOB_cookie != "undefined")
    {     
		if (MetrixLabGLOB_cookie==false)
		{                         
			//cookie not set
			MetrixLab_ShowOverlay();
		}
		else
		{
			//cookie set
		}
		
    }
	else
	{ 
		MetrixLabGLOB_Try_count--;
		if (MetrixLabGLOB_Try_count>0)
		{
			setTimeout('MetrixLabGLOB_checkCookie();',500);
		}
	}
}

function MetrixLab_CheckCookie()
{
	if (document.cookie.indexOf(MetrixLab_CookieName)==-1)
	{
		if (MetrixLab_GLOB_CookieSetup)
		{
			MetrixLab_GLOB_getCookie();
			MetrixLabGLOB_checkCookie();
		}
		else
			MetrixLab_ShowOverlay();
	}
	 
}

function MetrixLab_CheckIntercept()
{
	
    MetrixLab_RandomNumber = MetrixLab_GetRandomNumber(1,MetrixLab_Intercept);
    if (MetrixLab_RandomNumber==1)
    {
        MetrixLab_CheckXTVID(); 
    }
}

function MetrixLab_GoToPrivacy()
{
	PopupPrivacy = window.open('http://www.opinionbar.com/'+MetrixLab_PrivacyLanguage+'/privacy.asp','PopupPrivacy','resizable=yes,scrollbars=yes,toolbar=yes,menubar=yes,width=750,height=450');
}

function MetrixLab_GoToMetrixLab()
{
	PopupPrivacy = window.open('http://www.MetrixLab.com/','PopupPrivacy','resizable=yes,scrollbars=yes,toolbar=yes,menubar=yes,width=750,height=450');
}

function MetrixLab_GoToWebSurvey()
{
    switch(MetrixLab_OverlayType)
    {
        case 'entry':
            MetrixLab_GoToWebSurveyEntry();
        break;
        case 'exit':
            MetrixLab_GoToWebSurveyExit();
        break;
        case 'entryexit':
            MetrixLab_GoToWebSurveyEntryExit();
        break;
    }
}

function MetrixLab_GoToWebSurveyEntry()
{       
    if (MetrixLab_ForceData=='0')
    {					
        PopupWebSurvey = window.open('http://websurvey2.opinionbar.com/go.asp?s='+MetrixLab_ProjectNumber+'&c=overlay&t=4','PopupWebSurvey','resizable=yes,scrollbars=yes,toolbar=no,menubar=no,width=850,height=450');					
    }
    else
    {
        PopupWebSurvey = window.open('http://websurvey2.opinionbar.com/go.asp?s='+MetrixLab_ProjectNumber+'&c=overlay&t=4&f=;'+MetrixLab_ForceData+'','PopupWebSurvey','resizable=yes,scrollbars=yes,toolbar=no,menubar=no,width=850,height=450');
    }				

    MetrixLab_CloseBanner();
}

function MetrixLab_GoToWebSurveyExit()
{
   MetrixLab_SetCookie();
   MetrixLab_ShowPopupEntryExit();
   MetrixLab_CloseBanner();
}

function GoTowebSurveyEntryExit()
{
   MetrixLab_SetCookie();
   MetrixLab_ShowPopupEntryExit();
   MetrixLab_CloseBanner();
}

function MetrixLab_CloseBanner()
{
    var MetrixLab_Div=document.getElementById('MetrixLab_Div');
    if (MetrixLab_Div)
    {
        MetrixLab_Div.parentNode.removeChild(MetrixLab_Div);
    }
}

function MetrixLab_ShowPopupEntryExit()
{
	MetrixLab_PopupAttributes="resizable=yes,scrollbars=yes,toolbar=no,menubar=no,width=500,height=450";
	
	MetrixLab_PopupWin=open('', 'new_window', MetrixLab_PopupAttributes);
	
	var dom, s, code, body2, s2, body;
	dom = MetrixLab_PopupWin.document;
	var body;
	if(dom.body){
		body = dom.body;
	}else{
		body = dom.createElement("body");
		dom.documentElement.appendChild(body);
	}

	s = dom.createElement("script");
	s.type = 'text/javascript';
	code =  "var metrixlab_userid='"+MetrixLab_UserID+"';";
	code += "var metrixlab_ForceData='"+MetrixLab_ForceData+"';";
	//code += "var MetrixLab_ForceUtmz='"+MetrixLab_ForceUtmz+"';"; 
	code += "var MetrixLab_Protocol_parent='"+MetrixLab_Protocol+"';";
	body2 = MetrixLab_PopupWin.document.getElementsByTagName('body').item(0);
	
	var t = dom.createElement("table");
	var r = t.insertRow(0);
	var cell1 = r.insertCell(0);
	var img = dom.createElement("img");
	img.setAttribute("name","invitation_image");
	cell1.appendChild(img);

	body2.appendChild(t);

    try {
      s.appendChild(document.createTextNode(code));
      body2.appendChild(s);
    } catch (e) {
      s.text = code;
      body2.appendChild(s);
    }

    s2 = dom.createElement("script");
    s2.type = 'text/javascript';
    s2.src = MetrixLab_Protocol+"//invitation.opinionbar.com/popups/"+MetrixLab_PopupFolderName+"/exittest.js";
    body2.appendChild(s2);


	if (navigator.userAgent.indexOf('Firefox') !=-1)
	{
		MetrixLab_PopupWin.window.open('about:blank').close();
	}

	MetrixLab_PopupWin.blur();

	try {
	window.blur();
	window.focus();
	} catch(error){}
}

function Metrixlab_SetDivVisible()
{
	document.getElementById('MetrixLab_overlay').style.display='block';
}

function metrixlab_onready(el, func){
	this.args = new Array(el, func)
	this.doTry = function(){
			try{
					var el = eval(this.args[0])
					el.onloading = this.args[1]
					el.onloading()
					clearInterval(this.args[2])
			}
			catch(e){}
	}
	this.doTry.bind = function(object){
			var method = this;
			return function(){
					method.apply(object);
			}
	}
	this.args[2] = setInterval(this.doTry.bind(this), 250);
	return this
}

function MetrixLab_LoadOverlay()
{    
	MetrixLab_SetCookie();
	//console.log("overlay appeared");  
    var MetrixLab_HTMLString="";
    MetrixLab_HTMLString += "<MAP name='MetrixLab_Popup_Map'>\n";
    MetrixLab_HTMLString += " <AREA shape='rect' coords='"+MetrixLab_Coordinate_YesButton+"' href='javascript:MetrixLab_GoToWebSurvey();' target='_self'>\n";
    MetrixLab_HTMLString += " <AREA shape='rect' coords='"+MetrixLab_Coordinate_NoButton+"' href='javascript:MetrixLab_CloseBanner();' target='_self'>\n";
    MetrixLab_HTMLString += " <AREA shape='rect' coords='"+MetrixLab_Coordinate_CloseButton+"' href='javascript:MetrixLab_CloseBanner();' target='_self'>\n";
    MetrixLab_HTMLString += " <AREA shape='rect' coords='"+MetrixLab_Coordinate_PrivacyButton+"' href='javascript:MetrixLab_GoToPrivacy();' target='_self'>\n";
    MetrixLab_HTMLString += " <AREA shape='rect' coords='"+MetrixLab_Coordinate_MetrixButton+"' href='javascript:MetrixLab_GoToMetrixLab();' target='_self'>\n";    
    MetrixLab_HTMLString += "</MAP>\n";
    MetrixLab_HTMLString += "<div id='MetrixLab_overlay' style='display:none;position:absolute; z-index:9999; left: "+MetrixLab_DivStartLeft+"px; top: "+MetrixLab_DivStartTop+"px;'>";    
   // MetrixLab_HTMLString += "<img onload='Metrixlab_SetDivVisible();' src='"+MetrixLab_Protocol+"//invitation.opinionbar.com/popups/"+MetrixLab_PopupFolderName+"/overlay_p21408.png' USEMAP='#MetrixLab_Popup_Map' alt='' border='0' width='"+MetrixLab_OverlayWidth+"' height='"+MetrixLab_OverlayHeight+"' name='MetrixLab_overlay_gif' id='MetrixLab_gif'>";    
   MetrixLab_HTMLString += "<img onload='Metrixlab_SetDivVisible();' src='"+MetrixLab_Protocol+"//invitation.opinionbar.com/popups/"+MetrixLab_PopupFolderName+"/"+MetrixLab_OverlayImageName+"' USEMAP='#MetrixLab_Popup_Map' alt='' border='0' width='"+MetrixLab_OverlayWidth+"' height='"+MetrixLab_OverlayHeight+"' name='MetrixLab_overlay_gif' id='MetrixLab_gif'>";    
   
    MetrixLab_HTMLString += "</div>";
    
    var MetrixLab_Body=document.getElementsByTagName('body').item(0);
    var MetrixLab_Div = document.createElement('div');
    MetrixLab_Div.style.display='block';
    MetrixLab_Div.id='MetrixLab_Div';
    MetrixLab_Div.innerHTML = MetrixLab_HTMLString;
    MetrixLab_Body.appendChild(MetrixLab_Div);
}

if (MetrixLab_isCookieEnabled())
{
    MetrixLab_SetGlobOfWebsite();
}

if (MetrixLab_isCookieEnabled())
{
    new metrixlab_onready("document", function(){MetrixLab_CheckIntercept()});
}