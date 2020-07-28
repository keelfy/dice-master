<#import "../../part/_page.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
    <p class="display-4 text-center"><@spring.message "characters.classes.header"/></p>
    <hr>
    <div class="row cols-3">
        <div class="col-4">
            <div class="list-group" role="tablist">
                <h3 class="text-center"><@spring.message "sources.header"/></h3>

                <#assign allClassesCount = 0/>
                <#list gameSources as gameSource>
                    <#assign classesCount = gameSource.characterClasses?size/>
                    <#assign allClassesCount = allClassesCount + classesCount/>
                    <#if classesCount == 0><#continue/></#if>

                    <a class="list-group-item list-group-item-action" data-toggle="list" id="list-${gameSource.name}" href="#${gameSource.name}" role="tab">
                        <ul class="list-inline">
                            <div class="collection-left-bar">
                                <li class="list-inline-item float-left" style="width: 85%;">
                                    <@spring.message "source.${gameSource.name}.name"/>
                                </li>
                            </div>
                            <li class="list-inline-item float-right">
                                <span class="badge badge-secondary badge-pill mt-1">${classesCount}</span>
                            </li>
                        </ul>
                    </a>
                <#else>
                    <div class="alert alert-danger" role="alert">
                        Game Sources Unavailable
                    </div>
                </#list>

                <a class="list-group-item list-group-item-action active" data-toggle="list" id="list-all" href="#all" role="tab">
                    <ul class="list-inline">
                        <div class="collection-left-bar">
                            <li class="list-inline-item float-left" style="width: 85%;">
                                <@spring.message "sources.all"/>
                            </li>
                        </div>
                        <li class="list-inline-item float-right">
                            <span class="badge badge-secondary badge-pill mt-1">${allClassesCount}</span>
                        </li>
                    </ul>
                </a>
            </div>
        </div>

        <div class="col-8">
            <div class="tab-content" id="classes-tabcontent">
                <#list gameSources as gameSource>
                    <#if gameSource.characterClasses?size == 0><#continue></#if>
                    <div class="tab-pane" id="${gameSource.name}" role="tabpanel" aria-labelledby="list-${gameSource.name}">
                        <p class="lead text-center"><@spring.message "source.${gameSource.name}.name"/></p>
                        <#assign raceCounter = 0/>
                        <#list gameSource.characterClasses as characterClass>
                            <#assign raceCounter = raceCounter + 1/>

                            <#if raceCounter % 2 == 1>
                                <#if raceCounter != 1>
                                    </div>
                                </#if>
                                <div class="row">
                            </#if>

                            <div class="col-6 mb-4">
                                <a class="btn btn-light" role="button" href="classes/${characterClass.name}">
                                    <div class="p-3">
                                        <p class="text-center"><@spring.message "characters.classes.${characterClass.name}.name"/></p>
                                        <hr>
                                        <span><@spring.message "characters.classes.${characterClass.name}.desc.short"/></span>
                                    </div>
                                </a>
                            </div>
                        </#list>
                        </div>
                    </div>
                </#list>

                <div class="tab-pane show active" id="all" role="tabpanel" aria-labelledby="list-all">
                    <#list gameSources as gameSource>
                        <#if gameSource.characterClasses?size == 0><#continue></#if>
                        <p class="lead text-center"><@spring.message "source.${gameSource.name}.name"/></p>
                        <#assign raceCounter = 0/>
                        <#list gameSource.characterClasses as characterClass>
                            <#assign raceCounter = raceCounter + 1/>

                            <#if raceCounter % 2 == 1>
                                <#if raceCounter != 1>
                                    </div>
                                </#if>
                                <div class="row">
                            </#if>

                            <div class="col-6 mb-4">
                                <a class="btn btn-light" role="button" href="classes/${characterClass.name}">
                                    <div class="p-3">
                                        <p class="text-center"><@spring.message "characters.classes.${characterClass.name}.name"/></p>
                                        <hr>
                                        <span><@spring.message "characters.classes.${characterClass.name}.desc.short"/></span>
                                    </div>
                                </a>
                            </div>
                        </#list>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>

    <#include "../../part/_footer.ftlh">
</@c.page>