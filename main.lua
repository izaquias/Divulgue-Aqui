--local composer = require ("composer")
--composer.gotoScene("login")


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