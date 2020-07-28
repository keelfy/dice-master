<#macro navbar step>
<h1 class="display-7 text-center pb-4"><u>Character Building Utility</u></h1>

<ul class="nav nav-tabs mb-3">
    <li class="nav-item">
        <a class="nav-link <#if step?lower_case == "basics">active disabled</#if>" href="/characters/builder/basics" aria-disabled="<#if step?lower_case == "basics">true<#else>false</#if>">1. Basics</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <#if step?lower_case == "race">active disabled</#if>" href="/characters/builder/race" aria-disabled="<#if step?lower_case == "race">true<#else>false</#if>">2. Race</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <#if step?lower_case == "characterclass">active disabled</#if>" href="/characters/builder/characterclass" aria-disabled="<#if step?lower_case == "characterclass">true<#else>false</#if>">3. Class</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <#if step?lower_case == "abilities">active disabled</#if>" href="/characters/builder/abilities" aria-disabled="<#if step?lower_case == "abilities">true<#else>false</#if>">4. Abilities</a>
    </li>
</ul>
</#macro>