import Prelude
import Text.Show.Functions


-- a)
data Knoten = Bool deriving Show
data Blatt = Char deriving Show
data BinTree a b = Blatt b | Knoten a (BinTree a b) (BinTree a b) deriving Show 

-- b)
example :: BinTree (Int -> Bool) Char
example = Knoten (\x -> x > 4) (Knoten (\x-> x * x == x) (Blatt 'g') (Knoten (\x-> x == 0) (Blatt 'u') (Blatt 'l'))) (Knoten (\x-> x >=    7) (Blatt 'f') (Blatt 'i'))

-- c)
countInnerNodes :: BinTree a b -> Int
countInnerNodes (Knoten _ left right ) = 1 + countInnerNodes left + countInnerNodes right
countInnerNodes (Blatt _) = 0

-- d)
decodeInt :: BinTree (Int -> Bool) b -> Int -> b 
decodeInt (Blatt b) _ = b
decodeInt (Knoten a left right) x | a x = decodeInt right x
                                  | otherwise = decodeInt left x

--e)
decode:: BinTree (Int -> Bool) b -> [Int] -> [b]
decode bt [] = []
decode bt (x:xs) = decodeInt bt x : decode bt xs

--f)
insertSorted :: BinTree Int () -> Int -> BinTree Int ()
insertSorted (Blatt ()) x = (Knoten x (Blatt ()) (Blatt()) )
insertSorted (Knoten y left right) x | x < y = Knoten (y) (insertSorted left x) right
                                     | otherwise = Knoten (y) left (insertSorted right x)

--g)
treeSort :: [Int] -> [Int]
treeSort [] = []
treeSort xs = treeSorthilf xs (Blatt ())

treeSorthilf :: [Int] -> BinTree Int () -> [Int]
treeSorthilf [] a = in_order a
treeSorthilf (x:xs) a = treeSorthilf xs (insertSorted a x) 

in_order :: BinTree Int () -> [Int]
in_order (Blatt ()) = []
in_order (Knoten a l r) = in_order l ++ [a] ++ in_order r

--h)

mergeTrees :: BinTree Int () -> BinTree Int () -> BinTree Int ()
mergeTrees a (Blatt ()) = a
mergeTrees (Blatt()) a = a
mergeTrees a b = insertListSorted a (in_order b)

insertListSorted :: BinTree Int () -> [Int] -> BinTree Int ()
insertListSorted a [] = a 
insertListSorted a (x:xs) = insertListSorted (insertSorted a x) xs

