<#import "../part/_page.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
    <p class="display-4 text-center"><@spring.message "races.header"/></p>
    <hr>
    <div class="row cols-3">
        <div class="col-4">
            <div class="list-group align-middle" role="tablist">
                <h3 class="text-center"><@spring.message "sources.header"/></h3>

                <#assign allRacesCount = 0/>

                <#list gameSources as gameSource>
                    <#assign racesCount = gameSource.races?size/>
                    <#assign allRacesCount = allRacesCount + racesCount/>
                    <#if racesCount == 0><#continue/></#if>

                    <a class="list-group-item list-group-item-action" data-toggle="list" id="list-${gameSource.name}" href="#${gameSource.name}" role="tab">
                        <ul class="list-inline">
                            <div class="collection-left-bar">
                                <li class="list-inline-item float-left" style="width: 85%;">
                                    <@spring.message "source.${gameSource.name}.name"/>
                                </li>
                            </div>
                            <li class="list-inline-item float-right">
                                <span class="badge badge-secondary badge-pill mt-1">${racesCount}</span>
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
                            <span class="badge badge-secondary badge-pill mt-1">${allRacesCount}</span>
                        </li>
                    </ul>
                </a>
            </div>
        </div>

        <div class="col-8">
            <div class="tab-content">
                <#list gameSources as gameSource>
                    <#if gameSource.races?size == 0><#continue></#if>
                    <div class="tab-pane" id="${gameSource.name}" role="tabpanel" aria-labelledby="list-${gameSource.name}">
                        <p class="lead text-center"><@spring.message "source.${gameSource.name}.name"/></p>
                        <#assign raceCounter = 0/>
                        <#list gameSource.races as race>
                            <#if (raceCounter % 2 == 0) && (raceCounter > 0)>
                                </div>
                            </#if>

                            <#assign raceCounter = raceCounter + 1/>

                            <#if raceCounter % 2 == 1>
                                <div class="row">
                            </#if>

                            <div class="col-6 mb-4">
                                <a class="btn btn-light" role="button" href="races/${race.name}">
                                    <div class="p-3">
                                        <p class="text-center"><@spring.message "race.${race.name}.name"/></p>
                                        <hr>
                                        <span><@spring.message "race.${race.name}.desc.short"/></span>
                                    </div>
                                </a>
                            </div>
                        </#list>
                        </div>
                    </div>
                </#list>

                <div class="tab-pane show active" id="all" role="tabpanel" aria-labelledby="list-all">
                    <#list gameSources as gameSource>
                        <#if gameSource.races?size == 0><#continue></#if>

                        <p class="lead text-center"><@spring.message "source.${gameSource.name}.name"/></p>

                        <#assign raceCounter = 0/>
                        <#list gameSource.races as race>
                            <#if (raceCounter % 2 == 0) && (raceCounter > 0)>
                                </div>
                            </#if>

                            <#assign raceCounter = raceCounter + 1/>

                            <#if raceCounter % 2 == 1>
                                <div class="row">
                            </#if>

                            <div class="col-6 mb-4">
                                <a class="btn btn-light" role="button" href="races/${race.name}">
                                    <div class="p-3">
                                        <p class="text-center"><@spring.message "race.${race.name}.name"/></p>
                                        <hr>
                                        <span><@spring.message "race.${race.name}.desc.short"/></span>
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

    <#include "../part/_footer.ftlh">
</@c.page>