local widget =  require ("widget")
local composer = require ("composer")
local json = require( "json" )  -- Include the Corona JSON library
local webService = {}

local function handleResponse( event )

    if not event.isError then
        local response = json.decode( event.response )
        print( "erro : " .. event.response )
    else
        print( "Error" )
    end
    return
end
 
function webService:RegisterCustomerWS(nome,email,senha)
		
		local cliente = { nome = nome, email = email, senha = senha }
			
			local jsonCliente = json.encode(cliente)
			print("jsonCliente : " .. jsonCliente)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonCliente

		network.request( "http://localhost:8084/web-service/webresources/webService/usuario/insert", "POST", handleResponse, params )
end

return webService