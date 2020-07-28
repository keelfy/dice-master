<#import "../../part/_page.ftlh" as c>
<#import "part/_builderNavbar.ftlh" as n>
<#import "/spring.ftl" as spring>

<@c.page>
    <@n.navbar "characterclass"/>

    <h3 class="display-7">Available Classes</h3>

    <hr>

    <div>
        <p class="lead">Choose class</p>

        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Type class name..." aria-label="Search" aria-describedby="button-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Search</button>
            </div>
        </div>

        <#list characterClasses as characterClass>
        <#else>
            <div class="alert alert-danger" role="alert">
                Content Unavailable
            </div>
        </#list>

        <div class="row">
            <div class="col-4">
                <div class="list-group" id="list-tab" role="tablist">
                    <#list characterClasses as characterClass>
                        <#assign characterClassId = "characterClass-${characterClass.id}">
                        <a class="list-group-item list-group-item-action" id="list-${characterClassId}-list" data-toggle="list" href="#list-${characterClassId}" role="tab" aria-controls="${characterClassId}">
                            ${characterClass.name}
                        </a>
                    </#list>
                </div>
            </div>
            <div class="col-8">
                <div class="tab-content" id="nav-tabContent">
                    <#list characterClasses as characterClass>
                        <#assign characterClassId = "race-${characterClass.id}">
                        <div class="tab-pane fade" id="list-${characterClassId}" role="tabpanel" aria-labelledby="list-${characterClassId}-list">
                            ${characterClass.description}
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>

    <a role="button" href="/characters/builder/characterClass/" class="btn btn-primary btn-lg btn-block mt-3">Next Step</a>

    <#include "../../part/_footer.ftlh">
</@c.page>