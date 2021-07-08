<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commont/taglib.jsp"%>


<div id="successAlert3" class="swal2-container swal2-center swal2-backdrop-show" style="overflow-y: auto;
<c:if test="${messengeSuccess == null}" >
        display: none;
</c:if>
<c:if test="${messengeSuccess != null}" >
        display: unset;
</c:if>
        ">
    <div aria-labelledby="swal2-title" aria-describedby="swal2-content"
         class="swal2-popup swal2-modal swal2-icon-success swal2-show" tabindex="-1" role="dialog"
         aria-live="assertive" aria-modal="true" style="display: flex;">
        <div class="swal2-header">
            <div class="swal2-icon swal2-success swal2-icon-show" style="display: flex;">
                <div class="swal2-success-circular-line-left" style="background-color: rgb(255, 255, 255);">
                </div>
                <span class="swal2-success-line-tip"></span> <span class="swal2-success-line-long"></span>
                <div class="swal2-success-ring"></div>
                <div class="swal2-success-fix" style="background-color: rgb(255, 255, 255);"></div>
                <div class="swal2-success-circular-line-right" style="background-color: rgb(255, 255, 255);"></div>
            </div>
            <h2 class="swal2-title" id="swal2-title" style="display: flex;">${messengeSuccess}</h2>
        </div>
        <div class="swal2-actions">
            <button type="button" id="closeAlertSuccess" class="swal2-confirm swal2-styled" aria-label=""
                    style="display: inline-block;">OK
            </button>
        </div>
    </div>
</div>

<script>
    document.getElementById("closeAlertSuccess").onclick = closeAlert;
    function closeAlert() {
        document.getElementById("successAlert3").style.display = 'none';
    }
    setTimeout(closeAlert, 2000);
</script>