display.setStatusBar( display.HiddenStatusBar )-- ocultar o status bar

-- O objeto principal que a API Storyboard é manipular um objeto "cena".
-- https://coronalabs.com/blog/2012/03/27/storyboard-scene-events-explained/
--https://docs.coronalabs.com/guide/system/composer/index.html
local composer = require ("composer")
composer.gotoScene("CadastrarUsuario")


--[[
-----------------------------INSERIR O USUARIO NO BANCO DE DADOS ---------------------------------------
-- pegando o metodo do getUsuario da aplicacao web e inserindo no banco
local json = require( "json" )
local function handleResponse( event )
    if not event.isError then
        local response = json.decode( event.response )
        print( event.response )
    else
        print( "Error" )
    end
    return
end
 
network.request( "http://localhost:8084/web-service/webresources/webService/usuario/get", "GET", handleResponse )]]