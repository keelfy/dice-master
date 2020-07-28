<#import "part/_page.ftlh" as c>

<@c.page>
    <h1>Speaking Languages</h1>
    <#list languages as language>
        <div>
           ${language.id}: <b>${language.getFormattedTime()}</b>
        </div>
        <#else>
            No messages
    </#list>

    <form action="/options/speaking-language/add" method="post">
        <div class="form-group">
            <label for="language_name">Email address</label>
            <input type="text" class="form-control" id="language_name" placeholder="Type name of language">
        </div>
        <div class="form-group">
            <label for="language_description">Example textarea</label>
            <textarea class="form-control" id="language_description" rows="5"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</@c.page>