<#import "../../part/_page.ftlh" as c>
<#import "part/_builderNavbar.ftlh" as n>
<#import "/spring.ftl" as spring>

<@c.page>
    <@n.navbar "basics"/>

    <div class="py-3">
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Name</span>
            </div>
            <input type="text" class="form-control" placeholder="Character's name" value="${gameCharacter.name}" aria-label="Username" aria-describedby="basic-addon1">
        </div>
    </div>

    <div class="py-3">
        <h3 class="display-7"><@spring.message "characters.builder.basics.gameSources"/></h3>
        <hr class="my-2">
        <p class="lead">Allows to use custom game source for this character</p>

        <form>
            <#list gameSources as gameSource>
                <#assign gameSourceId = "gameSource_${gameSource.id}">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="${gameSourceId}">
                    <label class="form-check-label" for="${gameSourceId}">
                        ${gameSource.name} Content
                    </label>
                </div>
            <#else>
                <div class="alert alert-danger" role="alert">
                    Content Unavailable
                </div>
            </#list>
        </form>
    </div>

    <div class="py-3">
        <h3 class="display-7">Progression Type</h3>
        <hr class="my-2">
        <p class="lead">'Experience' type calculates level depends on experience while 'Milestone' type allows to up level when game master want to.</p>

        <form>
            <div class="form-group">
                <select class="form-control" id="characterProgressionType">
                    <#list characterProgressionTypes as progressionType>
                        <option>${progressionType}</option>
                    <#else>
                        <div class="alert alert-danger" role="alert">
                            Content Unavailable
                        </div>
                    </#list>
                </select>
            </div>
        </form>
    </div>

    <div class="py-3">
        <h3 class="display-7">Hit Points Calculation Type</h3>
        <hr class="my-2">
        <p class="lead">'Automatic' type calculates hit points based on formulas but 'Manual' type allows to change hit points manually.</p>

        <form>
            <div class="form-group">
                <select class="form-control" id="hitPointType">
                    <#list hitPointTypes as hitPointType>
                        <option>${hitPointType}</option>
                    <#else>
                        <div class="alert alert-danger" role="alert">
                            Content Unavailable
                        </div>
                    </#list>
                </select>
            </div>
        </form>
    </div>

    <div class="py-3">
        <h3 class="display-7">Weightless Money</h3>
        <hr class="my-2">

        <form>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="weightlessMoney">
                <label class="form-check-label" for="weightlessMoney">
                    Ignore money weight in character's inventory.
                </label>
            </div>
        </form>
    </div>

    <div class="py-3">
        <h3 class="display-7">Privacy</h3>
        <hr class="my-2">
        <p class="lead">Nobody can see private character, everbody can see public and only you and game members can see semiprivate.</p>

        <form>
            <div class="form-group">
                <select class="form-control" id="characterPrivacyType">
                    <#list characterPrivacyTypes as characterPrivacyType>
                        <option>${characterPrivacyType}</option>
                    <#else>
                        <div class="alert alert-danger" role="alert">
                            Content Unavailable
                        </div>
                    </#list>
                </select>
            </div>
        </form>
    </div>

    <a role="button" href="/characters/builder/race/" class="btn btn-primary btn-lg btn-block">Next Step</a>

    <#include "../../part/_footer.ftlh">
</@c.page>