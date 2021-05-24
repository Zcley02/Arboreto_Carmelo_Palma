package com.scrummaster.arboretocarmelopalma.intent

sealed class Intent{
    object GetTreeEvent: Intent()
    object None: Intent()
}
