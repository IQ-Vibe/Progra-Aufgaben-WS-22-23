--Teilaufgabe 1
symmetricDifference :: [Int] -> [Int] -> [Int]
symmetricDifference xs ys = difference xs ys ++ difference ys xs

difference :: [Int] -> [Int] -> [Int]
difference xs [] = xs
difference [] xs = []
difference (x:xs) ys    | contains x ys = difference xs ys
                        | otherwise = x : difference xs ys

contains :: Int -> [Int] -> Bool
contains x [] = False
contains x (y:xs)   | x == y = True
                    | otherwise = contains x xs

--Teilaufgabe 2
powerlist :: [Int] -> [[Int]]
powerlist xs = powerlisthelp xs [[]]

powerlisthelp :: [Int] -> [[Int]] -> [[Int]]
powerlisthelp [] acc = acc
powerlisthelp (x:xs) acc = powerlisthelp xs (acc ++ appendToSublists x acc)

appendToSublists :: Int -> [[Int]] -> [[Int]]
appendToSublists _ [] = []
appendToSublists x (ys:yss) = appendToSublist x ys : appendToSublists x yss

appendToSublist :: Int -> [Int] -> [Int]
appendToSublist x ys = ys ++ [x]

-- Teilaufgabe 3
permutations :: [Int] -> [[Int]]
permutations [] = [[]]
permutations xs = [x : ys | x <- xs, ys <- permutations (delete x xs)]

delete :: Int -> [Int] -> [Int]
delete _ [] = []
delete x (y:ys) | x == y    = ys
                | otherwise = y : delete x ys

--Teilaufgabe 4
nodes :: [(Int,Int)] -> [Int]
nodes es = nodeshelper es []

nodeshelper :: [(Int,Int)] -> [Int] -> [Int]
nodeshelper  [] es = es
nodeshelper  ((a,b):rest) es    |not (contains a es) && not (contains b es) = nodeshelper rest (es ++ [a] ++ [b])
                                |not (contains a es) && contains b es = nodeshelper rest (es ++ [a])
                                |contains a es && not (contains b es) = nodeshelper rest (es ++ [b])
                                |otherwise = nodeshelper rest es

--Teilaufgabe 5
existsPath :: [(Int, Int)] -> Int -> Int -> Bool
existsPath es a b
  | a == b = True  -- Der Startknoten ist bereits der Endknoten
  | otherwise = dfs a []
  where
    dfs :: Int -> [Int] -> Bool
    dfs current visited
      | current == b = True
      | otherwise =
        let neighbors = filter (\(_, neighbor) -> neighbor `notElem` visited) (filter (\(source, _) -> source == current) es)
        in any (\(_, neighbor) -> dfs neighbor (current : visited)) neighbors

--Teilaufgabe 6
isConnected :: [(Int,Int)] -> Bool
isConnected es = isConnectedhelper es (nodes es) (nodes es)

isConnectedhelper :: [(Int,Int)] -> [Int] -> [Int] -> Bool
isConnectedhelper _ _ [] = True
isConnectedhelper es nodes (x:xs) | existsPathTravers es nodes x = isConnectedhelper es nodes xs

existsPathTravers :: [(Int,Int)] -> [Int] -> Int -> Bool
existsPathTravers _ [] _ = True
existsPathTravers es (x:xs) knoten  | existsPath es knoten x = existsPathTravers es xs knoten
                                    | otherwise = False