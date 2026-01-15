export default function SystemDesign() {
  const topics = [
    { q: 'Horizontal Scaling', a: 'Add more servers to distribute load. Easier than vertical scaling and provides better fault tolerance.' },
    { q: 'Vertical Scaling', a: 'Increase server resources (CPU, RAM). Has hardware limits but simpler architecture.' },
    { q: 'Load Balancing', a: 'Distributes traffic across servers. Algorithms: Round Robin, Least Connections, IP Hash.' },
    { q: 'Database Sharding', a: 'Partitions data across multiple databases. Improves scalability but increases complexity.' },
    { q: 'CAP Theorem', a: 'Consistency, Availability, Partition Tolerance - pick two. Distributed systems cannot guarantee all three.' },
    { q: 'Caching', a: 'Stores frequently accessed data in memory. Reduces database load and improves response time.' },
  ];

  return (
    <div className="space-y-6">
      <h1 className="text-3xl font-bold text-gray-900">System Design FAQs</h1>
      {topics.map((t, i) => (
        <div key={i} className="bg-white rounded-lg shadow p-6">
          <h3 className="text-xl font-semibold text-gray-900 mb-2">{t.q}</h3>
          <p className="text-gray-700">{t.a}</p>
        </div>
      ))}
    </div>
  );
}
