Funcion boolean <- addPlayer ( player )
	
	BTSTree.addPlayersItems(player)
	AVLTree.addPlayersItems(player)
	RBTree.addPlayersItems(player)
Fin Funcion

Funcion boolean <- readInformation ( file, txtType )
	definir added como logico
	added<-false
	definir bf como BufferedReader
	definir line como texto 
	line<- bf.readLine
	
	Mientras line!= null Hacer
		
		Dimension playerData(12)
		Si txtType==CSV_FILE  Entonces
			playerData<- line.Split(",")
		SiNo
			PlayerData<- line.Split(" ")
		Fin Si
		
		playerName<- playerData[0]   
		playerGender<- playerData[1]
		PlayerAge<-playerData[2]
		PlayerGamesPlayed<-playerData[3]
		PlayerMinutesPlayed<-playerData[4]
		PlayerFieldGoalsPercentage<-playerData[5]
		PlayerThreePointsFieldPercentage<-playerData[6]
		PlayerAgeFreeThrowPercentage<-playerData[7]
		PlayerPersonalFouls<-playerData[8]
		playerImpactEstimate<-playerData[9]
		PlayerOffensiveReboundPercentage<-playerData[10]
		PlayerTurnoverPercentage<-playerData[11]
		
		definir newPlayer como Player
		newPlayer<- Player(playerName,playerGender,playerAge,playerGamesPlayed,PlayerMinutesPlayed,PlayerFieldGoalsPercentage,
						PlayerThreePointsFieldPercentage,PlayerAgeFreeThrowPercentage,PlayerPersonalFouls,playerImpactEstimate,
						PlayerOffensiveReboundPercentage,PlayerTurnoverPercentage)
		
		
		added <- addPlayer(newPlayer)
		line<- bf.readLine
	Fin Mientras
	
	
Fin Funcion





Algoritmo addPlayersWithFile
	
	
FinAlgoritmo
