<#import "/spring.ftl" as spring>

<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="form-group">
            <label class="col-sm-2 col-form-label" for="username"><@spring.message "login.username"/></label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="username" placeholder="<@spring.message "login.placeholder.username"/>"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 col-form-label" for="password"><@spring.message "login.password"/></label>
            <div class="col-sm-6">
                <input class="form-control" type="password" name="password" placeholder="<@spring.message "login.placeholder.password"/>"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit"><#if !isRegisterForm><@spring.message "login.signin"/><#else><@spring.message "login.signup"/></#if></button>
        <#if !isRegisterForm><a href="/registration"><@spring.message "login.registration"/></a></#if>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit"><@spring.message "logout"/></button>
    </form>
</#macro>