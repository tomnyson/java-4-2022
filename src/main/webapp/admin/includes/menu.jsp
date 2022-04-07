<%-- 
    Document   : menu.jsp
    Created on : Mar 22, 2022, 6:27:32 AM
    Author     : tomnyson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
          <div class="app-brand demo">
            <a href="index.html" class="app-brand-link">
              <span class="app-brand-text demo menu-text fw-bolder ms-2">Shopping</span>
            </a>

            <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
              <i class="bx bx-chevron-left bx-sm align-middle"></i>
            </a>
          </div>

          <div class="menu-inner-shadow"></div>

          <ul class="menu-inner py-1">
            <!-- Dashboard -->
            <li class="menu-item">
              <a href="${pageContext.request.contextPath}/dashboard" class="menu-link">
                <i class="menu-icon tf-icons bx bx-home-circle"></i>
                <div data-i18n="Analytics">Dashboard</div>
              </a>
            </li>

            <!-- Layouts -->
            <li class="menu-item active open">
              <a href="javascript:void(0);" class="menu-link menu-toggle">
                <i class="menu-icon tf-icons bx bx-layout"></i>
                <div data-i18n="Layouts">Layouts</div>
              </a>

              <ul class="menu-sub">
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/admin/AdminCategoryController" class="menu-link">
                    <div data-i18n="Without menu">category</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="${pageContext.request.contextPath}/admin/AdminProductController" class="menu-link">
                    <div data-i18n="Without navbar">product</div>
                  </a>
                </li>
                <li class="menu-item active">
                  <a href="layouts-container.html" class="menu-link">
                    <div data-i18n="Container">order</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="layouts-fluid.html" class="menu-link">
                    <div data-i18n="Fluid">user</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a href="layouts-blank.html" class="menu-link">
                    <div data-i18n="Blank">setting</div>
                  </a>
                </li>
              </ul>
            </li>

          </ul>
        </aside>
