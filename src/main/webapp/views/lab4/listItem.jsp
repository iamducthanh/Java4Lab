<%@include file="/commont/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách item</title>
</head>
<body>
<div class="row" style="margin-top: 50px">
    <body oncontextmenu='return false' class='snippet-body'>
    <h3>Danh sách sản phẩm</h3>
    <div class="container mt-5">
        <div class="row">
            <c:forEach var="itemItem" items="${listItem}">
                <div class="col-md-3 productItem" style="margin-bottom: 25px">
                    <div class="cardLab4">
                        <div class="image-container">
                            <div class="first">
                                <div class="d-flex justify-content-between align-items-center"> <span
                                        class="discount">-0%</span> <span class="wishlist"><i
                                        class="fa fa-heart-o"></i></span></div>
                            </div>
                            <a href="<c:url value="/lab4/product-details?id=${itemItem.id}"/>">
                                <img src="<c:url value="/commont/images/${itemItem.anhItem}"/>"
                                     class="img-fluid rounded thumbnail-image">
                            </a>
                        </div>
                        <div class="product-detail-container p-2">
                            <div class="d-flex justify-content-between align-items-center">
                                <h5 class="dress-name">${itemItem.tenItem}</h5>
                                <div class="d-flex flex-column mb-2"><span class="new-price">$${itemItem.giaGiam}</span> <small
                                        class="old-price text-right">$${itemItem.giaItem}</small></div>
                            </div>
                            <div class="d-flex justify-content-between align-items-center pt-1">
                                <div class="color-select d-flex "><input type="button" name="grey" class="btn1 creme">
                                    <input type="button" name="red" class="btn1 red ml-2"> <input type="button"
                                                                                                 name="blue"
                                                                                                 class="btn1 blue ml-2">
                                </div>
                                <div class="d-flex ">
                                    <c:if test="${itemItem.giaItem >= 50}">
                                        <span class="mr-2">Giá cao</span>
                                    </c:if>
                                    <c:if test="${itemItem.giaItem < 50}">
                                        <span class="mr-2">Giá thấp</span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="d-flex justify-content-between align-items-center pt-1">
                                <div><i class="fa fa-star-o rating-star"></i> <span class="rating-number">4.8</span>
                                </div>
                                <span class="buy">Ngày: ${itemItem.ngayNhap}</span>
                            </div>
                        </div>
                    </div>
                    <div class="mt-3">
                        <div class="card voutchers">
                            <div class="voutcher-divider">
                                <div class="voutcher-left text-center"><span class="voutcher-name">Monday Happy</span>
                                    <h5 class="voutcher-code">#MONHPY</h5>
                                </div>
                                <div class="voutcher-right text-center border-left">
                                    <h5 class="discount-percent">20%</h5> <span class="off">Off</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    </body>
</div>
</body>
</html>
