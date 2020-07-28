<#import "part/_page.ftlh" as c>
<#import "part/_login.ftlh" as l>

<@c.page>
    <h1>Add new user</h1>
    ${message?ifExists}
    <@l.login "/registration" true/>
</@c.page>