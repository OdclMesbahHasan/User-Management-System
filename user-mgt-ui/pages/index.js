import Head from "next/head";
import AddUser from "../components/AddUser";
import Navbar from "../components/Navbar";
// You can keep this if you need to display a list of users

export default function Home() {
    return (
        <div>
            <Head>
                <title>User management App</title>
            </Head>
            <Navbar />
            <main>
                <AddUser />
            </main>
        </div>
    );
}
