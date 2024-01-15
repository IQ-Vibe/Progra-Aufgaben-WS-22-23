--a)
data Rosebush = Rose | Cut | Stalk Rosebush | Fork Rosebush Rosebush deriving Show

generate :: Rosebush
generate = Stalk (Fork ((Stalk (Fork (Stalk (generate)) (Stalk Rose)))) (Stalk (Stalk(Fork (Stalk Rose) (Stalk (Stalk (Stalk(generate))))))))

--loeschen
r :: Rosebush
r = (Fork Rose (Fork Rose (Fork Cut Cut)))
--loeschen

--b)
cut :: Int -> Rosebush -> Rosebush
cut x bush = cuthelp x 1 bush 

cuthelp :: Int -> Int -> Rosebush -> Rosebush 
cuthelp x y  (Cut) = Cut
cuthelp x y  (Rose)         | x < y = Cut
                            | otherwise = Rose
cuthelp x y  (Stalk a)      | x == y = (Stalk Cut)
                            | otherwise = (Stalk (cuthelp x (y+1) (a))) 
cuthelp x y  (Fork a b)     | x == y = (Fork Cut Cut)
                            | otherwise = (Fork (cuthelp x (y+1) a) (cuthelp x (y+1) b))

--c)
countRoses :: Rosebush -> Int
countRoses (Rose) = 1
countRoses (Cut) = 0
countRoses (Stalk a) = countRoses a
countRoses (Fork a b) = countRoses a + countRoses b

countCuts :: Rosebush -> Int
countCuts (Rose) = 1
countCuts (Cut) = 0
countCuts (Stalk a) = countCuts a
countCuts (Fork a b) = countCuts a + countCuts b

--d)
rosesOnLevel :: Rosebush -> Int -> Int
rosesOnLevel bush x = rosesOnLevelrecurs bush x 1

rosesOnLevelrecurs :: Rosebush -> Int -> Int -> Int
rosesOnLevelrecurs (Rose) x y = if x == y then 1 else 0 
rosesOnLevelrecurs (Cut) x y = 0
rosesOnLevelrecurs (Stalk a) x y = rosesOnLevelrecurs a x (y+1)
rosesOnLevelrecurs (Fork a b) x y = rosesOnLevelrecurs a x (y+1) + rosesOnLevelrecurs b x (y+1)

--e)
cutRoseBalance :: Rosebush -> Int
cutRoseBalance bush = cutRoseBalanceHelp bush (hoehe bush)

cutRoseBalanceHelp :: Rosebush -> Int -> Int
cutRoseBalanceHelp bush x   | x<2 = 1    --falls es nicht erreichbar ist
                            | countCuts(cut x bush) == countRoses(cut x bush) = x
                            | otherwise = cutRoseBalanceHelp (cut x bush) x-1

hoehe :: Rosebush -> Int
hoehe (Rose) = 1
hoehe (Cut) = 0
hoehe (Stalk a) = 1 + hoehe a 
hoehe (Fork a b) = if hoehe a > hoehe b then 1 + hoehe a else 1 + hoehe b

-- given
spaces :: Int -> String
spaces 0 = ""
spaces n = " " ++ spaces (n-1)

dashes :: Int -> String
dashes 0 = ""
dashes n = "-" ++ dashes (n-1)

zipOutput :: [String] -> Int -> [String] -> Int -> [String]
zipOutput [] _ [] _           = []
zipOutput (x:xs) n1 [] n2     = (x ++ " " ++ (spaces n2)):(zipOutput xs n1 [] n2)
zipOutput [] n1 (y:ys) n2     = ((spaces n1) ++ " " ++ y):(zipOutput [] n1 ys n2)
zipOutput (x:xs) n1 (y:ys) n2 = (x ++ " " ++ y):(zipOutput xs n1 ys n2)

data Output = Output [String] Int Int

display :: Rosebush -> Output
display Rose = Output ["*"] 1 1
display Cut = Output ["X"] 1 1
display (Stalk p) = Output (line:o) i n
               where line = (spaces (i-1)) ++ "|" ++ (spaces (n-i))
                     Output o i n = display p
display (Fork p1 p2) = Output (line:(zipOutput o1 n1 o2 n2)) (n1+1) (n1+1+n2)
               where line = (spaces (i1-1)) ++ "+" ++ (dashes (n1-i1)) ++ "+"
                         ++ (dashes (i2-1)) ++ "+" ++ (spaces (n2-i2))
                     Output o1 i1 n1 = display p1
                     Output o2 i2 n2 = display p2

concatenate :: [String] -> String
concatenate []     = ""
concatenate (x:xs) = (concatenate xs) ++ x ++ "\n"

showMe rosebush = putStr (concatenate o)
                  where Output o _ _ = display rosebush
