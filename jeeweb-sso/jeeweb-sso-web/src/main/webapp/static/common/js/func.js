/*!
 * Copyright &copy; 2016-2020 <a href="http://www.jeeweb.cn/">JeeWeb</a> All rights reserved.
 * 
 * 一些公共的方法
 * @author auth_team
 * @version 2017-06-03
 */
/*{
 "*":/[\w\W]+/,
 "*6-16":/^[\w\W]{6,16}$/,
 "n":/^\d+$/,
 "n6-16":/^\d{6,16}$/,
 "s":/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]+$/,
 "s6-18":/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{6,18}$/,
 "p":/^[0-9]{6}$/,
 "m":/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/,
 "e":/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
 "url":/^(\w+:\/\/)?\w+(\.\w+)+.*$/
 }
 "*":"不能为空！",
 "*6-16":"请填写6到16位任意字符！",
 "n":"请填写数字！",
 "n6-16":"请填写6到16位数字！",
 "s":"不能输入特殊字符！",
 "s6-18":"请填写6到18位字符！",
 "p":"请填写邮政编码！",
 "m":"请填写手机号码！",
 "e":"邮箱地址格式不对！",
 "url":"请填写网址！"
 */
function validformJqgrid(value, datatype, nullmsg, errormsg) {
	var reg = "";
	var defaultNullmsg = "不能为空！";
	var defaultErrormsg = "";
	var first = datatype.substr(0, 1);
	var end = datatype.substring(1);
	var startNumber = 0;
	var endNumber = 0;
	if (end != '') {
		var startEnds = end.split("-");
		startNumber = startEnds[0];
		endNumber = startEnds[0];
		if (startEnds.length == 2) {
			endNumber = startEnds[1];
		}
	}
	switch (first) {
	case "*":
		defaultNullmsg = "不能为空！";
		reg = /[\w\W]+/;
		if (end != '') {
		  defaultNullmsg = "请填写"+startNumber+"到"+endNumber+"位任意字符！";
		  reg=eval("/^[\\w\\W]{"+startNumber + ","+endNumber + "}$/gim")
 		}
		break;
	case "n":
		defaultNullmsg = "请填写数字！";
		reg = /^\d+$/;
		if (end != '') {
			  defaultNullmsg = "请填写"+startNumber+"到"+endNumber+"位数字！";
			  reg=eval("/^\\d{"+startNumber + ","+endNumber + "}$/gim")
	 	}
		break;
	case "s":
		defaultNullmsg = "不能输入特殊字符！";
		reg = /^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]+$/;
		if (end != '') {
			  defaultNullmsg = "请填写"+startNumber+"到"+endNumber+"位字符！";
			  reg=eval("/^[\\u4E00-\\u9FA5\\uf900-\\ufa2d\\w\\.\\s]{"+startNumber + ","+endNumber + "}$/gim")
	 	}
		break;
	case "p":
		defaultNullmsg = "请填写邮政编码！";
		reg = /^[0-9]{6}$/;
		break;
	case "m":
		defaultNullmsg = "请填写手机号码！";
		reg = /^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/;
		break;
	case "e":
		defaultNullmsg = "邮箱地址格式不对！";
		reg = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		break;
	case "url":
		defaultNullmsg = "请填写网址！";
		reg = /^(\w+:\/\/)?\w+(\.\w+)+.*$/;
		break;
	case "/":
		reg = datatype;
		break;
	default:
		
	}
	if(value==undefined||value==''){
		if(nullmsg==undefined||nullmsg==''){
			nullmsg=defaultNullmsg;
		}
		return [false, nullmsg];
	}
	var r = value.match(reg);
	if (r == null){
		if(errormsg==undefined||errormsg==''){
			errormsg=defaultNullmsg;
		}
		return [false, errormsg];
    }
	return [ true, "" ];
}