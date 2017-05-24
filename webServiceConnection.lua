local widget =  require ("widget")
local composer = require ("composer")
local json = require( "json" )  -- Include the Corona JSON library
local webService = {}

local function handleResponse( event )

    if not event.isError then
        local response = json.decode( event.response )
        print( "erro : " .. event.response )
        print(response.email)
    else
        print( "Error" )
    end
    return
end

function webService:RegisterUserWS(nome,email,senha) -- registrar usuario
		
		local usuario = { nome = nome, email = email, senha = senha }
			
			local jsonUsuario = json.encode(usuario)
			print("jsonCliente : " .. jsonUsuario)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonUsuario
																											--login:
		network.request( "http://localhost:8084/web-service/webresources/webService/usuario/insert", "POST", handleResponse, params )
end

function webService:recoverUser(nome) -- recuperar usuario
	
	local usuario = { nome = nome}
			
	local jsonUsuario = json.encode(usuario)
		print("jsonUsuario : " .. jsonUsuario)
	local headers = {}
					  
	headers["Content-Type"] = "application/json"

	local params = {}

	params.headers = headers

	params.body = jsonUsuario

	network.request( "http://localhost:8084/web-service/webresources/webService/usuario/recuperarPorNome?nome="..nome, "GET", handleResponse, params )
end
 


function webService:RegisteremployeeWS(localidade,descricao,categoria) -- registrar funcionario
		
		local funcionario = { localidade = localidade, descricao = descricao, categoria = categoria }
			
			local jsonFuncionario = json.encode(funcionario)
			print("jsonFuncionario : " .. jsonFuncionario)
			local headers = {}
					  
			headers["Content-Type"] = "application/json"

			local params = {}

			params.headers = headers

			params.body = jsonFuncionario

		network.request( "http://localhost:8084/web-service/webresources/webService/feed/insert", "POST", handleResponse, params )
end

return webService