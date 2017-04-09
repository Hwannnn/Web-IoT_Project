$("#login-button").click(function(event){
	event.preventDefault();
	 
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});

function tab_load(n){
    var i;
    for (i = 1; i < 6; i++) {
    	if(document.getElementById('tab_'+i) != null) {
    		document.getElementById('tab_'+i).className = '';
    
    	}
    }
    document.getElementById('tab_'+n).className = 'active';
}

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("./jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadFullAddr.value = roadFullAddr;
		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.addrDetail.value = addrDetail;

}

