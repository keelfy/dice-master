<#import "../../part/_page.ftlh" as c>
<#import "part/_builderNavbar.ftlh" as n>
<#import "/spring.ftl" as spring>

<@c.page>
    <@n.navbar "race"/>

    <div>
        <h3 class="display-7">Available Sources Filter</h3>

        <form>
            <div class="form-group">
                <select class="form-control" id="gameSource">
                    <#list gameSources as gameSource>
                        <option>${gameSource.name}</option>
                    <#else>
                        <div class="alert alert-danger" role="alert">
                            Content Unavailable
                        </div>
                    </#list>
                </select>
            </div>
        </form>
    </div>

    <hr>

    <div>
        <p class="lead">Choose game source with world races</p>

        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Type race name..." aria-label="Search" aria-describedby="button-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Search</button>
            </div>
        </div>

        <div class="row">
            <div class="col-4">
                <div class="list-group" id="list-tab" role="tablist">
                    <#list races as race>
                    <#assign raceId = "race-${race.id}">
                        <a class="list-group-item list-group-item-action" id="list-${raceId}-list" data-toggle="list" href="#list-${raceId}" role="tab" aria-controls="${raceId}">
                            ${race.name}
                        </a>
                    </#list>
                </div>
            </div>
            <div class="col-8">
                <div class="tab-content" id="nav-tabContent">
                    <#list races as race>
                        <#assign raceId = "race-${race.id}">
                        <div class="tab-pane fade" id="list-${raceId}" role="tabpanel" aria-labelledby="list-${raceId}-list">
                            ${race.description}
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>

    <a role="button" href="/characters/builder/characterClass/" class="btn btn-primary btn-lg btn-block mt-3">Next Step</a>

    <#include "../../part/_footer.ftlh">
</@c.page>