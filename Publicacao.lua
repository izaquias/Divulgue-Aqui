local widget =  require ("widget") -- para os botoes
local composer = require ("composer") -- para as telas
local web = require ("webServiceConnection")
local scene = composer.newScene()

local labelDescricao
local txtDescricao

local labelLocalidade
local txtLocalidade

local buttonPublish -- botao de publicar

 function scene:create(event)

	local grupoCena = self.view 

     labelDescricao = display.newText({text = "Descricao", x=display.contentWidth/2, y=display.contentHeight/2 - 70, native.systemFont, 16})
     labelDescricao:setFillColor(0,1,0)
     grupoCena:insert( labelDescricao )

     labelCategoria = display.newText({text = "Categoria", x=display.contentWidth/2, y=display.contentHeight/2 - 170, native.systemFont, 16})
     labelCategoria:setFillColor(0,1,0)
     grupoCena:insert( labelCategoria )

     labelLocalidade = display.newText({text = "Local", x=display.contentWidth/2,y=display.contentHeight/2 - 120, native.systemFont, 16})
     labelLocalidade:setFillColor(0,1,0)
     grupoCena:insert( labelLocalidade )

     buttonPublish = widget.newButton( {label = "Publicar", x = display.contentWidth/2 - 50,y = display.contentHeight/2 + 60, native.systemFont, 20, onPress = registrarPublicacao} )
     grupoCena:insert( buttonPublish )
end


function scene:show( event )
 
 local phase = event.phase
 
    if ( phase == "will" ) then
		txtCategoria = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 150, 200, 25 ) 
		txtLocalidade = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 100 , 200, 25 ) 
		txtDescricao = native.newTextBox( display.contentWidth/2, display.contentHeight/2 - 10, 200, 100, native.systemFont, 200)
    txtDescricao.isEditable = true
    txtDescricao.size  = 14
		end 			
    
end
 

function registrarPublicacao( event )
  if event.phase == "began" then
    web:RegisterFeedWS(txtLocalidade.text,txtDescricao.text, txtCategoria.text, codigoUser)
  --  txtDescricao.text = ""
  --  txtCategoria.text = ""
  --  txtLocalidade.text = ""
    composer.gotoScene("Logado")
  end
end

function scene:hide( event )
 
   -- local sceneGroup = self.view
   local phase = event.phase
 
    if ( phase == "will" ) then
        -- Code here runs when the scene is on screen (but is about to go off screen)
      display.remove(txtDescricao)
	    display.remove(txtCategoria)
	    display.remove(txtLocalidade)
	    
    end
end
 
 
-- destroy()
function scene:destroy( event )
 
    --local sceneGroup = self.view
    -- Code here runs prior to the removal of scene's view
 
end




scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )

return scene