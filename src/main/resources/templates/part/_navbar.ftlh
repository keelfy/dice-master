<#include "_security.ftlh">
<#import "_login.ftlh" as l>
<#import "/spring.ftl" as spring>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Dice Master</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/"><@spring.message "navigation.home"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main"><@spring.message "navigation.visits"/></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <@spring.message "navigation.collections"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="races"><@spring.message "navigation.collections.races"/></a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="classes"><@spring.message "navigation.collections.classes"/></a>
                </div>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user"><@spring.message "navigation.userlist"/></a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <#if name != "unknown"><@l.logout/></#if>
    </div>
</nav>