<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="<c:url value="/commont/images/${model.anhItem}"/>" alt="..." /></div>
            <div class="col-md-6">
                <div class="small mb-1">SKU: BST-498</div>
                <h1 class="display-5 fw-bolder">${model.tenItem}</h1>
                <div class="fs-5 mb-5">
                    <span class="text-decoration" style="color: red">Giá mới: $${model.giaGiam}</span> <br/>
                    <span class="text-decoration-line-through">Giá cũ: $${model.giaItem}</span> <br/>
                    <c:if test="${model.giaGiam >= 50}">
                        <span class="mr-2">Mức giá: Giá cao</span>
                    </c:if>
                    <c:if test="${model.giaGiam < 50 && model.giaGiam >= 10}">
                        <span class="mr-2">Mức giá: Bình thường</span>
                    </c:if>
                    <c:if test="${model.giaGiam < 10}">
                        <span class="mr-2">Mức giá: Giá thấp</span>
                    </c:if>
                    <br/>
                    <br/>
                    <span class="text-decoration">Ngày: ${model.ngayNhap}</span>
                </div>
                <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi consequatur obcaecati excepturi alias magni, accusamus eius blanditiis delectus ipsam minima ea iste laborum vero?</p>
                <div class="d-flex">
                    <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                    <button class="btn btn-outline-dark flex-shrink-0" type="button">
                        <i class="bi-cart-fill me-1"></i>
                        Add to cart
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>