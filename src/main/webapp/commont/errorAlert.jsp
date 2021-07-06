<div id="errorLogin" class="swal2-container swal2-center swal2-backdrop-show" style="overflow-y: auto; display: ${display}">
    <div aria-labelledby="swal2-title" aria-describedby="swal2-content"
         class="swal2-popup swal2-modal swal2-icon-error swal2-show" tabindex="-1" role="dialog"
         aria-live="assertive" aria-modal="true" style="display: flex;">
        <div class="swal2-header">
            <div class="swal2-icon swal2-error swal2-icon-show" style="display: flex;"><span class="swal2-x-mark">
                            <span class="swal2-x-mark-line-left"></span>
                            <span class="swal2-x-mark-line-right"></span>
                        </span>
            </div>
            <h2 class="swal2-title" id="swal2-title" style="display: flex;">${messenge}</h2>
        </div>

        <div class="swal2-actions">
            <div class="swal2-loader"></div>
            <button type="button" class="swal2-confirm swal2-styled" id="closeAl" aria-label=""
                    style="display: inline-block;">OK
            </button>
        </div>
    </div>
</div>

<script>
    document.getElementById("closeAl").onclick = closeAlert;

    function closeAlert() {
        console.log(document.getElementById("errorLogin"));
        document.getElementById("errorLogin").style.display = 'none';
    }

</script>