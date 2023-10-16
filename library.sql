-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-10-2023 a las 03:47:16
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `library`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `author` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `category` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `books`
--

INSERT INTO `books` (`id`, `name`, `description`, `author`, `stock`, `category`) VALUES
(6, 'To Kill a Mockingbird', 'This classic novel explores themes of racial injustice and moral growth in the American South during the 1930s.', 'Harper Lee', 10, 'Fiction'),
(7, '1984', 'A dystopian classic that depicts a totalitarian regime and government surveillance.', 'George Orwell', 8, 'Science Fiction'),
(8, 'The Great Gatsby', 'A tale of decadence and ambition in the Roaring Twenties.', 'F. Scott Fitzgerald', 12, 'Fiction'),
(9, 'Pride and Prejudice', 'A classic of English literature exploring love and social norms in the 19th century.', 'Jane Austen', 15, 'Fiction'),
(10, 'The Catcher in the Rye', 'A coming-of-age novel following the disillusionment of Holden Caulfield.', 'J.D. Salinger', 7, 'Fiction'),
(11, 'The Hobbit', 'A fantasy adventure about Bilbo Baggins and a dragon.', 'J.R.R. Tolkien', 5, 'Fantasy'),
(12, 'The Da Vinci Code', 'A thriller combining art, history, and conspiracy.', 'Dan Brown', 9, 'Mystery'),
(13, 'The Alchemist', 'A philosophical and inspirational tale of a shepherd in search of his personal legend.', 'Paulo Coelho', 11, 'Philosophy'),
(14, 'Gone Girl', 'A psychological thriller about a marriage gone wrong.', 'Gillian Flynn', 6, 'Mystery'),
(15, 'The Girl with the Dragon Tattoo', 'A suspenseful mystery investigating a wealthy family\'s dark secrets.', 'Stieg Larsson', 8, 'Mystery'),
(16, 'The Road', 'A post-apocalyptic novel about a father and sons journey for survival.', 'Cormac McCarthy', 10, 'Fiction'),
(17, 'The Hunger Games', 'A dystopian series where teens fight for their lives in a televised event.', 'Suzanne Collins', 14, 'Young Adult'),
(18, 'The Martian', 'A tale of an astronaut stranded on Mars, struggling to survive.', 'Andy Weir', 8, 'Science Fiction'),
(19, 'Moby-Dick', 'An epic novel of obsession and revenge at sea.', 'Herman Melville', 12, 'Adventure'),
(20, 'The Shining', 'A horror novel about a family trapped in a haunted hotel.', 'Stephen King', 6, 'Horror'),
(21, 'The Hitchhikers Guide to the Galaxy', 'A comedic science fiction series about the misadventures of an unwitting space traveler.', 'Douglas Adams', 11, 'Science Fiction'),
(22, 'The Road Not Taken: Edward Lansdale and the American Tragedy in Vietnam', 'A biography exploring Edward Lansdale\'s role in Vietnam.', 'Max Boot', 3, 'Biography'),
(23, 'The Power of Habit', 'A book on the science of habit formation and its effects on our lives.', 'Charles Duhigg', 9, 'Self-Help'),
(24, 'Sapiens: A Brief History of Humankind', 'A non-fiction book exploring the history and impact of Homo sapiens.', 'Yuval Noah Harari', 7, 'Non-Fiction'),
(25, 'The Night Circus', 'A fantasy novel about a magical competition between two young illusionists.', 'Erin Morgenstern', 10, 'Fantasy'),
(26, 'Brave New World', 'A dystopian novel exploring a future society driven by technological and genetic advancements.', 'Aldous Huxley', 5, 'Science Fiction'),
(27, 'The Kite Runner', 'A novel about the complicated relationship between two friends in Afghanistan.', 'Khaled Hosseini', 13, 'Fiction'),
(28, 'The Subtle Art of Not Giving a F*ck', 'A self-help book that offers unconventional wisdom for a happy life.', 'Mark Manson', 8, 'Self-Help'),
(29, 'The Goldfinch', 'A coming-of-age novel about a young boy who loses his mother in a tragic event.', 'Donna Tartt', 6, 'Fiction'),
(30, 'The Art of War', 'An ancient Chinese military treatise on strategy and tactics.', 'Sun Tzu', 15, 'Non-Fiction'),
(31, 'The Book Thief', 'A novel narrated by Death, following a girl in Nazi Germany.', 'Markus Zusak', 9, 'Historical Fiction'),
(32, 'The Silent Patient', 'A psychological thriller about a woman who shoots her husband and then stops speaking.', 'Alex Michaelides', 7, 'Mystery'),
(33, 'The Catcher in the Rye', 'A coming-of-age novel following the disillusionment of Holden Caulfield.', 'J.D. Salinger', 7, 'Fiction'),
(34, 'The Old Man and the Sea', 'A classic novella about an old Cuban fisherman and his battle with a giant marlin.', 'Ernest Hemingway', 11, 'Adventure'),
(35, 'A Brief History of Time', 'A non-fiction exploration of the universe, black holes, and the nature of time.', 'Stephen Hawking', 5, 'Science'),
(36, 'The Giver', 'A dystopian novel where a young boy learns the dark truth behind his seemingly utopian society.', 'Lois Lowry', 10, 'Young Adult');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
