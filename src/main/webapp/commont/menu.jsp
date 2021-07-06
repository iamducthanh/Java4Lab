<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                    <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                    Java Lab
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                            Lab 1
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="<c:url value="/lab1?type=helloservlet"/>">Hello servlet</a>
                                <a class="nav-link" href="<c:url value="/lab1?type=hello"/>">Hello</a>
                                <a class="nav-link" href="<c:url value="/lab1?type=hinh-chu-nhat"/>">Hình chữ nhật</a>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                            Lab 2
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="<c:url value="/lab2/tam-giac"/>">Hình tam giác</a>
                                <a class="nav-link" href="<c:url value="/lab2/dang-ki"/>">Đăng kí</a>
                                <a class="nav-link" href="<c:url value="/lab2/signup"/>">Đăng kí 1</a>
                                <a class="nav-link" href="<c:url value="/lab2/bai4"/>">Vòng đời servlet</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError1" aria-expanded="false" aria-controls="pagesCollapseError1">
                            Lab 3
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseError1" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="<c:url value="/lab3/upload-file"/>">Upload file</a>
                                <a class="nav-link" href="<c:url value="/lab3/beanutils"/>">Sử dụng BeanUtils</a>
                                <a class="nav-link" href="<c:url value="/lab3/dang-ki"/>">Đăng kí</a>
                                <a class="nav-link" href="<c:url value="/dang-nhap"/>">Đăng nhập</a>
                                <a class="nav-link" href="<c:url value="/lab3/send-email"/>">Gửi email</a>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError3" aria-expanded="false" aria-controls="pagesCollapseError3">
                            Lab 4
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseError3" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="<c:url value="/lab4/items"/>">Danh sách item</a>
                                <a class="nav-link" href="<c:url value="/lab4/user-management"/>">Quản lí người dùng</a>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#pagesCollapseError4" aria-expanded="false" aria-controls="pagesCollapseError4">
                            Lab 5
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseError4" aria-labelledby="headingOne" data-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="<c:url value="/lab5/test-jpa"/>">Test Jpa</a>
                                <a class="nav-link" href="<c:url value="/lab5/quan-li-user"/>">Quản lí user</a>

                            </nav>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </nav>
</div>