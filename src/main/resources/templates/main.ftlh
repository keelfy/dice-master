<#import "part/_page.ftlh" as c>

<@c.page>
    <h1>Welcome to Spring, ${name}</h1>
    <span><a href="/user">User list</a></span>
    <span><a href="/options">World Options</a></span>
    <span><a href="/characters/builder/basics">Create your character</a></span>
    <span><a href="/races">Races</a></span>

    <#list visits as visit>
        <div>
           ${visit.id}: <b>${visit.getFormattedTime()}</b>
        </div>
        <#else>
            No messages
    </#list>
</@c.page>